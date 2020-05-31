package com.demko.grpc_soc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

import generated.UserServiceGrpc;
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
import generated.UserServiceGrpc.UserServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

	static boolean isAuthorized = false;
	static ManagedChannel channel;
	static UserServiceBlockingStub stub;
	static String token = "";
	static int id = -1;

	public static void main(String[] args) {

		channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		stub = UserServiceGrpc.newBlockingStub(channel);

		basePage();
	}

	private static void reverse() {
		System.out.println("Введите строку:");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();

		ReverseRequest request = ReverseRequest.newBuilder().setInputStr(userInput).build();
		APIResponse response = stub.reverse(request);

		System.out.println(response.getMsg());
	}

	private static void basePage() {
		System.out.println("1. Регистрация: reg");
		System.out.println("2. Авторизация: login");
		System.out.println("3. Выход: q");
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		while (!isAuthorized) {
			userInput = scanner.nextLine();
			if (userInput.equals("login")) {
				login();
				if (isAuthorized) {
					mainPage();
					System.out.println("1. Регистрация: reg");
					System.out.println("2. Авторизация: login");
					System.out.println("3. Выход: q");
				}
			} else if (userInput.equals("reg")) {
				registration();
			} else if (userInput.equals("reverse")) {
				reverse();
			} else if (userInput.equals("q")) {
				System.exit(0);
			} else {
				System.out.println("Неопознанная операция!");
			}
		}

	}

	private static void mainPage() {
		System.out.println("1. Получить список постов: getNoteList");
		System.out.println("2. Написать пост: writeNote");
		System.out.println("3. Лайкнуть пост: like {id поста}");
		System.out.println("4. Просмотреть список комментариев к посту: getCommentList {id поста}");
		System.out.println("5. Оставить комментарий к посту: writeComment {id поста}");
		System.out.println("6. Написать сообщение: writeMessage {id пользователя}");
		System.out.println("7. Получить список пользователей: getUserList");
		System.out.println("8. Получить список диалогов: getCorrespList");
		System.out.println("9. Получить диалог: getCorresp {id диалога}");
		System.out.println("10. Выход: q");

		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		while (isAuthorized) {
			userInput = scanner.nextLine();
			String params[] = userInput.split(" ");

			int noteid = -1;

			switch (params[0]) {
			case "getCorrespList":
				getCorrespList();
				break;
			case "getCorresp":
				try {
					if (params.length < 2) {
						System.out.println("id не должен быть пустым!");
					} else {
						noteid = Integer.parseInt(params[1]);
						if (noteid > 0)
							getCorresp(noteid);
						else {
							System.out.println("id должен быть больше нуля!");
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case "getUserList":
				getUserList();
				break;
			case "getNoteList":
				getNoteList();
				break;
			case "writeNote":
				writeNote();
				break;
			case "like":
				try {
					if (params.length < 2) {
						System.out.println("id не должен быть пустым!");
					} else {
						noteid = Integer.parseInt(params[1]);
						if (noteid > 0)
							like(noteid);
						else {
							System.out.println("id должен быть больше нуля!");
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

				break;
			case "getCommentList":
				try {
					if (params.length < 2) {
						System.out.println("id не должен быть пустым!");
					} else {
						noteid = Integer.parseInt(params[1]);
						if (noteid > 0)
							getCommentList(noteid);
						else {
							System.out.println("id должен быть больше нуля!");
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case "writeComment":
				try {
					if (params.length < 2) {
						System.out.println("id не должен быть пустым!");
					} else {
						noteid = Integer.parseInt(params[1]);
						if (noteid > 0)
							writeComment(noteid);
						else {
							System.out.println("id должен быть больше нуля!");
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case "writeMessage":
				try {
					if (params.length < 2) {
						System.out.println("id не должен быть пустым!");
					} else {
						noteid = Integer.parseInt(params[1]);
						if (noteid > 0)
							writeMessage(noteid);
						else {
							System.out.println("id должен быть больше нуля!");
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case "q":
				isAuthorized = false;
				logout();
				// logout
				break;
			default:
				System.out.println("Неопознанная операция!");
				break;
			}
		}
		// basePage();
	}

	private static void logout() {
		LogoutRequest request = LogoutRequest.newBuilder().setId(id).build();
		APIResponse response = stub.logout(request);

		System.out.println(response.getMsg());

	}

	private static void getCorrespList() {
		GetCorrespListRequest request = GetCorrespListRequest.newBuilder().setUserid(id).build();
		GetCorrespListResponse response = stub.getCorrespList(request);

		if (response.getCorrespList().size() == 0) {
			System.out.println("Пусто");
		} else {
			for (Corresp corresp : response.getCorrespList()) {
				System.out.println(corresp.getName() + " (" + corresp.getId() + ")");
			}
		}
	}

	private static void getCorresp(int correspid) {
		GetMessageListRequest request = GetMessageListRequest.newBuilder().setCorrespid(correspid).build();
		GetMessageListResponse response = stub.getMessageList(request);

		if (!response.getError()) {
			for (Message msg : response.getMsgList()) {
				System.out.println(msg.getDate() + "\n" + msg.getFirstName() + " " + msg.getLastName() + ": "
						+ msg.getMsg() + "\n");
			}
		}
	}

	private static void getUserList() {
		EmptyRequest request = EmptyRequest.newBuilder().build();
		GetUserListResponse response = stub.getUserList(request);

		for (UserDB user : response.getUserList()) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " (" + user.getId() + ")");
		}
	}

	private static void writeMessage(int compid) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст сообщения:");
		String content = scanner.nextLine();

		SendMessageRequest request = SendMessageRequest.newBuilder().setUserid(id).setCompid(compid).setContent(content)
				.build();
		APIResponse response = stub.sendMessage(request);

		System.out.println(response.getMsg());
	}

	private static void writeComment(int noteid) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст комментария:");
		String content = scanner.nextLine();

		CreateCommentRequest request = CreateCommentRequest.newBuilder().setUserid(id).setNoteid(noteid)
				.setContent(content).build();
		APIResponse response = stub.createComment(request);

		System.out.println(response.getMsg());
	}

	private static void getNoteList() {
		Formatter f = new Formatter();

		GetNoteListRequest request = GetNoteListRequest.newBuilder().setToken(token).build();

		GetNoteListResponse response = stub.getNoteList(request);
		String header = "";
		String textField = "";
		String bottom = "";
		int size = 0;

		if (response.getNoteList().size() == 0) {
			System.out.println("Пусто");
		} else {
			for (Note note : response.getNoteList()) {
				header = String.format("id: %d, author: %s %s", note.getId(), note.getAuthFirstName(),
						note.getAuthLastName());
				textField = String.format("Text: %s", note.getContent());
				bottom = String.format("comments: %d   likes: %d", note.getCommentAmount(), note.getLikeAmount());

				if (textField.length() > header.length()) {
					if (textField.length() > bottom.length())
						size = textField.length();
					else
						size = bottom.length();
				} else {
					if (header.length() > bottom.length())
						size = header.length();
					else
						size = bottom.length();
				}

				String b = "";
				for (int i = 0; i < size; i++) {

					b += "-";
				}
				while (header.length() < size)
					header += ' ';
				while (textField.length() < size)
					textField += ' ';
				while (bottom.length() < size)
					bottom += ' ';

				System.out.println(b);
				System.out.println(header + "|");
				System.out.println(textField + "|");
				System.out.println(bottom + "|");
				System.out.println(b);
			}
		}
	}

	private static void writeNote() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст записи:");
		String content = scanner.nextLine();

		CreateNoteRequest request = CreateNoteRequest.newBuilder().setUserid(id).setContent(content).build();
		APIResponse response = stub.createNote(request);

		System.out.println(response.getMsg());
	}

	private static void like(int noteid) {
		SetLikeRequest request = SetLikeRequest.newBuilder().setNoteid(noteid).setUserid(id).build();
		APIResponse response = stub.setLike(request);

		System.out.println(response.getMsg());
	}

	private static void getCommentList(int noteid) {
		GetCommentListRequest request = GetCommentListRequest.newBuilder().setNoteid(noteid).build();
		GetCommentListResponse response = stub.getCommentList(request);

		if (!response.getError()) {
			if (response.getCommentCount() > 0) {
				for (Comment comment : response.getCommentList()) {
					System.out.println(String.format("***comment from: %s %s***\n>%s\n\n", comment.getFirstName(),
							comment.getLastName(), comment.getText()));
				}
			} else {
				System.out.println("Нет комментариев к данной записи!");
			}
		} else {
			System.out.println(response.getMsg());
		}

	}

	private static void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите логин:");
		String login = scanner.nextLine();
		System.out.println("Введите пароль:");
		String password = scanner.nextLine();

		LoginRequest request = LoginRequest.newBuilder().setLogin(login).setPassword(password).build();
		LoginResponse response = stub.login(request);
		// отправка запроса на авторизацию
		if (!response.getError()) {
			isAuthorized = true;
			token = response.getToken();
			id = response.getId();
			System.out.println("token: " + token);
			System.out.println("id: " + id);
		}

		System.out.println(response.getMsg());

	}

	private static void registration() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите имя:");
		String firstName = scanner.nextLine();
		System.out.println("Введите фамилию:");
		String lastName = scanner.nextLine();
		System.out.println("Введите логин:");
		String login = scanner.nextLine();
		System.out.println("Введите пароль:");
		String password = scanner.nextLine();

		// отправка запроса на регистрацию
		RegistrationRequest request = RegistrationRequest.newBuilder().setFirstName(firstName).setLastName(lastName)
				.setLogin(login).setPassword(password).build();

		APIResponse response = stub.registration(request);

		System.out.println(response.getMsg());

	}

}
