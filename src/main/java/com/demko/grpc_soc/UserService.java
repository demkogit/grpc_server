package com.demko.grpc_soc;

import java.security.MessageDigest;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

import generated.User.APIResponse;
import generated.User.Comment;
import generated.User.Corresp;
import generated.User.CreateCommentRequest;
import generated.User.CreateNoteRequest;
import generated.User.EmptyRequest;
import generated.User.GetCommentListRequest;
import generated.User.GetCommentListResponse;
import generated.User.GetCorrespListRequest;
import generated.User.GetCorrespListResponse;
import generated.User.GetMessageListRequest;
import generated.User.GetMessageListResponse;
import generated.User.GetNoteListRequest;
import generated.User.GetNoteListResponse;
import generated.User.GetUserListResponse;
import generated.User.LoginRequest;
import generated.User.LoginResponse;
import generated.User.LogoutRequest;
import generated.User.Message;
import generated.User.Note;
import generated.User.RegistrationRequest;
import generated.User.ReverseRequest;
import generated.User.SendMessageRequest;
import generated.User.SetLikeRequest;
import generated.User.UserDB;
import generated.UserServiceGrpc.UserServiceImplBase;
import io.grpc.stub.StreamObserver;

public class UserService extends UserServiceImplBase {

	@Override
	public void reverse(ReverseRequest request, StreamObserver<APIResponse> responseObserver) {
		String inputString = request.getInputStr();
		APIResponse.Builder response = APIResponse.newBuilder();
		StringBuilder sb = new StringBuilder(inputString);

		response.setError(false).setMsg(sb.reverse().toString());

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	public String MD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(input.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

	@Override
	public void registration(RegistrationRequest request, StreamObserver<APIResponse> responseObserver) {
		// System.out.println("in registration");
		String firstName = request.getFirstName();
		String lastName = request.getLastName();
		String password = request.getPassword();
		String login = request.getLogin();

		int inserted = 0;

		DBWorker worker = DBWorker.getInstance();

		APIResponse.Builder response = APIResponse.newBuilder();

		try {

			String pass = MD5(login + password);

			PreparedStatement statement = worker.getConnection()
					.prepareStatement("INSERT INTO USERS VALUES(nextval(\'serial_users\'),?,?,?,?);");
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, pass);
			statement.setString(4, login);

			inserted = statement.executeUpdate();

			response.setError(false).setMsg("Вы успешно зарегистрировались!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setError(true).setMsg("e.getMessage()");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {

		String login = request.getLogin();
		String password = request.getPassword();

		DBWorker worker = DBWorker.getInstance();

		LoginResponse.Builder response = LoginResponse.newBuilder();

		try {
			// Class.forName("org.postgresql.Driver");
			String pass = MD5(login + password);

			PreparedStatement statement = worker.getConnection()
					.prepareStatement("SELECT users.id from users where users.login = ? and users.pass = ? ;");
			statement.setString(1, login);
			statement.setString(2, pass);

			ResultSet result = statement.executeQuery();

			int id = -1;

			while (result.next()) {
				id = result.getInt(1);
			}
			if (id == -1) {
				response.setError(true).setMsg("Неверный логин/пароль!");
			} else {
				Random rand = new Random();
				rand.setSeed(42);

				String token = MD5("" + rand.nextInt(100000000));

				statement = worker.getConnection().prepareStatement("INSERT INTO online_users VALUES(?,?);");
				statement.setInt(1, id);
				statement.setString(2, token);

				int inserted = statement.executeUpdate();

				response.setError(false).setMsg("Вы успешно авторизовались!").setToken(token).setId(id);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setError(true).setMsg(e.getMessage());
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void getNoteList(GetNoteListRequest request, StreamObserver<GetNoteListResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		GetNoteListResponse.Builder response = GetNoteListResponse.newBuilder();

		PreparedStatement statement;
		try {
			statement = worker.getConnection().prepareStatement(
					"SELECT notes.id, notes.text, users.firstName, users.lastName, count_comments.count as comments, count_likes.count as likes FROM notes left join count_comments ON notes.id= count_comments.noteid join users ON notes.userid = users.id left join count_likes on notes.id = count_likes.noteid;");
			ResultSet result = statement.executeQuery();
			int id;
			String text;
			String firstName;
			String lastName;
			int likeAmount;
			int commentAmount;

			while (result.next()) {
				id = result.getInt(1);
				text = result.getString(2);
				firstName = result.getString(3);
				lastName = result.getString(4);
				commentAmount = result.getInt(5);
				likeAmount = result.getInt(6);

				response.addNote(Note.newBuilder().setId(id).setAuthFirstName(firstName).setAuthLastName(lastName)
						.setContent(text).setCommentAmount(commentAmount).setLikeAmount(likeAmount).build());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();

	}

	@Override
	public void logout(LogoutRequest request, StreamObserver<APIResponse> responseObserver) {

		int id = request.getId();
		DBWorker worker = DBWorker.getInstance();

		APIResponse.Builder response = APIResponse.newBuilder();

		try {
			PreparedStatement statement = worker.getConnection()
					.prepareStatement("delete from online_users where userid = ? ;");
			statement.setInt(1, id);

			int inserted = statement.executeUpdate();
			response.setError(false).setMsg("Вы вышли!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setError(true).setMsg(e.getMessage());
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void createNote(CreateNoteRequest request, StreamObserver<APIResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		int id = request.getUserid();
		String content = request.getContent();

		APIResponse.Builder response = APIResponse.newBuilder();

		try {
			PreparedStatement statement = worker.getConnection()
					.prepareStatement("insert into notes values(nextval(\'serial_notes\'), ?, ?);");
			statement.setInt(1, id);
			statement.setString(2, content);
			int inserted = statement.executeUpdate();

			response.setError(false).setMsg("Вы отправили запись!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setError(true).setMsg(e.getMessage());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void setLike(SetLikeRequest request, StreamObserver<APIResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		int noteid = request.getNoteid();
		int userid = request.getUserid();

		APIResponse.Builder response = APIResponse.newBuilder();

		PreparedStatement statement;
		try {
			statement = worker.getConnection().prepareStatement("select id from notes where id = ?");
			statement.setInt(1, noteid);

			ResultSet result = statement.executeQuery();

			int id = -1;

			while (result.next()) {
				id = result.getInt(1);
			}
			if (id == -1) {
				response.setError(true).setMsg("Запись с таким id отсутствует!");
			} else {
				statement = worker.getConnection().prepareStatement("INSERT INTO likes VALUES(?,?);");
				statement.setInt(1, noteid);
				statement.setInt(2, userid);

				int inserted = statement.executeUpdate();

				response.setError(false).setMsg("Вам понравилась запись: " + id + "!");
			}

		} catch (SQLException e) {
			if (e.getErrorCode() == 0) {
				try {
					statement = worker.getConnection()
							.prepareStatement("delete from likes where userid = ? and noteid = ?");
					statement.setInt(1, userid);
					statement.setInt(2, noteid);
					int inserted = statement.executeUpdate();

					response.setError(true).setMsg("Данная запись вам понравилась ранее. Лайк снят");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else
				response.setError(true).setMsg("SQLException code: " + e.getErrorCode());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void getCommentList(GetCommentListRequest request, StreamObserver<GetCommentListResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		int noteid = request.getNoteid();

		GetCommentListResponse.Builder response = GetCommentListResponse.newBuilder();

		PreparedStatement statement;
		try {
			statement = worker.getConnection().prepareStatement("select id from notes where id = ?");
			statement.setInt(1, noteid);

			ResultSet result = statement.executeQuery();

			int id = -1;

			while (result.next()) {
				id = result.getInt(1);
			}
			if (id == -1) {
				response.setError(true).setMsg("Запись с таким id отсутствует!");
			} else {
				statement = worker.getConnection().prepareStatement(
						"select comments.text, users.firstName, users.lastName from comments, users where comments.noteid = ? and comments.authorid= users.id order by comments.id;");
				statement.setInt(1, noteid);

				result = statement.executeQuery();

				String text = "";
				String firstName = "";
				String lastName = "";

				while (result.next()) {
					text = result.getString(1);
					firstName = result.getString(2);
					lastName = result.getString(3);
					response.addComment(
							Comment.newBuilder().setText(text).setFirstName(firstName).setLastName(lastName).build());
				}
			}

		} catch (SQLException e) {
			response.setError(true).setMsg("SQLException code: " + e.getErrorCode());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void createComment(CreateCommentRequest request, StreamObserver<APIResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		int userid = request.getUserid();
		int noteid = request.getNoteid();
		String content = request.getContent();

		APIResponse.Builder response = APIResponse.newBuilder();

		try {
			PreparedStatement statement = worker.getConnection()
					.prepareStatement("insert into comments values(?, ?, ?, nextval('serial_comments'));");
			statement.setInt(1, noteid);
			statement.setInt(2, userid);
			statement.setString(3, content);
			int inserted = statement.executeUpdate();

			response.setError(false).setMsg("Вы отправили комментарий!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setError(true).setMsg(e.getMessage());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void getUserList(EmptyRequest request, StreamObserver<GetUserListResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		GetUserListResponse.Builder response = GetUserListResponse.newBuilder();

		try {
			PreparedStatement statement = worker.getConnection()
					.prepareStatement("select id, firstname, lastname from users;");
			ResultSet result = statement.executeQuery();

			int id = -1;
			String firstName = "";
			String lastName = "";
			while (result.next()) {
				id = result.getInt(1);
				firstName = result.getString(2);
				lastName = result.getString(3);
				response.addUser(UserDB.newBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void sendMessage(SendMessageRequest request, StreamObserver<APIResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		int userid = request.getUserid();
		int compid = request.getCompid();
		String content = request.getContent();

		APIResponse.Builder response = APIResponse.newBuilder();

		try {
			PreparedStatement statement = worker.getConnection()
					.prepareStatement("select firstname, lastname from users where id = ?;");
			statement.setInt(1, compid);
			ResultSet result = statement.executeQuery();
			String compFirstName = "";
			String compLastName = "";
			while (result.next()) {
				compFirstName = result.getString(1);
				compLastName = result.getString(2);
			}
			if (compFirstName.isEmpty() && compLastName.isEmpty()) {
				response.setError(false).setMsg("Пользователя с таким id не существует!");
			} else {
				statement = worker.getConnection().prepareStatement(
						"select correspid from participant where participant.userid = ? and correspid in (select correspid from participant where userid = ?);");
				statement.setInt(1, userid);
				statement.setInt(2, compid);
				
				result = statement.executeQuery();
				int correspid = -1;
				while (result.next()) {
					correspid = result.getInt(1);
				}
				if (correspid == -1) {

					statement = worker.getConnection()
							.prepareStatement("select firstname, lastname from users where id = ?;");
					statement.setInt(1, userid);

					result = statement.executeQuery();
					String userFirstName = "";
					String userLastName = "";
					while (result.next()) {
						userFirstName = result.getString(1);
						userLastName = result.getString(2);
					}

					//
					String correspName = userFirstName + " " + userLastName + " : " + compFirstName + " "
							+ compLastName;
					statement = worker.getConnection()
							.prepareStatement("insert into corresp values(nextval('serial_corresp'), ?);");
					statement.setString(1, correspName);
					int inserted = statement.executeUpdate();

					statement = worker.getConnection().prepareStatement("select id from corresp where name = ?;");
					statement.setString(1, correspName);
					result = statement.executeQuery();

					if (result.next())
						correspid = result.getInt(1);

					statement = worker.getConnection().prepareStatement("insert into participant values(?, ?);");
					statement.setInt(1, correspid);
					statement.setInt(2, userid);

					inserted = statement.executeUpdate();

					statement = worker.getConnection().prepareStatement("insert into participant values(?, ?);");
					statement.setInt(1, correspid);
					statement.setInt(2, compid);

					inserted = statement.executeUpdate();

				}

				java.util.Date date = new java.util.Date();
				Timestamp t = new Timestamp(date.getTime());
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				statement = worker.getConnection().prepareStatement("insert into message values(1, ?, ?, ?, ?);");
				statement.setInt(1, correspid);
				statement.setInt(2, userid);
				statement.setString(3, content);
				statement.setTimestamp(4, t);

				int inserted = statement.executeUpdate();

				response.setError(false).setMsg("Сообщение отправлено " + compFirstName + " " + compLastName + "!");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setError(true).setMsg(e.getMessage());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void getCorrespList(GetCorrespListRequest request, StreamObserver<GetCorrespListResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		int userid = request.getUserid();
		GetCorrespListResponse.Builder response = GetCorrespListResponse.newBuilder();

		try {
			PreparedStatement statement = worker.getConnection().prepareStatement(
					"select corresp.id, corresp.name from participant, corresp where corresp.id = participant.correspid and participant.userid = ?;");
			statement.setInt(1, userid);
			ResultSet result = statement.executeQuery();

			int correspid = -1;
			String correspname = "";
			while (result.next()) {
				correspid = result.getInt(1);
				correspname = result.getString(2);
				response.addCorresp(Corresp.newBuilder().setId(correspid).setName(correspname).build());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();

	}

	@Override
	public void getMessageList(GetMessageListRequest request, StreamObserver<GetMessageListResponse> responseObserver) {
		DBWorker worker = DBWorker.getInstance();

		int correspid = request.getCorrespid();

		GetMessageListResponse.Builder response = GetMessageListResponse.newBuilder();

		try {
			PreparedStatement statement = worker.getConnection().prepareStatement(
					"select message.content, message.sdate, users.firstName, users.lastname from message, users where users.id = message.userid and message.correspid = ?;");
			statement.setInt(1, correspid);

			ResultSet result = statement.executeQuery();

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String firstName = "";
			String lastName = "";
			String dateStr = "";
			String content = "";
			Timestamp timestamp;
			
			while (result.next()) {
				content = result.getString(1);
				timestamp = result.getTimestamp(2);
				dateStr = format.format(timestamp);
				firstName = result.getString(3);
				lastName = result.getString(4);
				response.addMsg(Message.newBuilder().setMsg(content).setDate(dateStr).setFirstName(firstName)
						.setLastName(lastName).build());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setError(true).setMsge(e.getMessage());
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

}
