package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.ZoneId;

public class MainController {

	private ArrayList<Player> players_List = new ArrayList<Player>();
	private ArrayList<String> players_NameList = new ArrayList<String>();

	@FXML
	private TabPane tabPane;
	@FXML
	private Tab view_Tab;

	@FXML
	private Tab game_Tab;

	@FXML
	private Tab player_Tab;

	@FXML
	private Tab addgame_Tab;

	@FXML
	private Tab gamePlayed_Tab;

	private ArrayList<Game> games_List = new ArrayList<Game>();
	private ArrayList<String> games_NameList = new ArrayList<String>();
	@FXML
	private ListView<String> PlayerGameId_ListView;
	@FXML
	private ListView<String> GameId_ListView;
	@FXML
	private ListView<String> PlayerId_ListView;
	@FXML
	private ListView<String> PlayingDate_ListView;
	@FXML
	private ListView<String> Score_ListView;
	@FXML
	private ComboBox<Object> players_Combo = new ComboBox<>();
	@FXML
	private TextField ViewPlayerId_TextField;
	@FXML
	private TextField ViewFirstName_TextField;
	@FXML
	private TextField ViewLastName_TextField;
	@FXML
	private TextField ViewAddress_TextField;
	@FXML
	private TextField ViewPostalCode_TextField;
	@FXML
	private TextField ViewProvince_TextField;
	@FXML
	private TextField ViewPhoneNumber_TextField;
	@FXML
	private Button EditButton;
	@FXML
	private Button UpdateButton;

	// add player Buttons
	@FXML
	private TextField addPlayerId_TextField;
	@FXML
	private TextField addFirstName_TextField;
	@FXML
	private TextField addLastName_TextField;
	@FXML
	private TextField addAddress_TextField;
	@FXML
	private TextField addPostalCode_TextField;
	@FXML
	private TextField addProvince_TextField;
	@FXML
	private TextField addPhoneNumber_TextField;
	@FXML
	private Button Addplayer_Button;
	@FXML
	private Label addPlayerMessage;

	// add game tab
	@FXML
	private TextField GameName_TextField;
	@FXML
	private Button AddGame_Button;
	@FXML
	private Label AddGameMessage;
	@FXML
	private ComboBox<Object> gameResultPlayers_ComboBox = new ComboBox<>();
	@FXML
	private DatePicker gameResultStart_DatePicker = new DatePicker();
	@FXML
	private DatePicker gameResultEnd_DatePicker = new DatePicker();
	@FXML
	private TableView<?> G_ResultsTable = new TableView<Object>();

	// game played tab
	@FXML
	private ComboBox<Object> gamePlayedPlayers_ComboBox = new ComboBox<>();

	@FXML
	private ComboBox<Object> gamePlayed_ComboBox = new ComboBox<>();

	@FXML
	private DatePicker gamePlayed_DatePicker = new DatePicker();

	@FXML
	private TextField gamePlayedScore;
	@FXML
	private Button addGamePlayedRecord;

	@FXML
	private Button gameResultFilter_Button = new Button();

	// private ObservableList<?> data;

	@FXML
	public void initialize() {
		System.out.println("> Start Program ...");
		
		players_Combo.setOnAction(new ViewComboHandler());
		EditButton.setOnAction(new ViewEditButtonHandler());
		UpdateButton.setOnAction(new ViewUpdateButtonHandler());
		Addplayer_Button.setOnAction(new AddPlayerAddButtonHandler());
		AddGame_Button.setOnAction(new AddGameAddButtonHandler());
		addGamePlayedRecord.setOnAction(new GamePlayedRecordHandler());
		gameResultFilter_Button.setOnAction(new GamePlayedFilterButtonHandler());

		ViewPlayerId_TextField.setEditable(false);
		ViewFirstName_TextField.setEditable(false);
		ViewLastName_TextField.setEditable(false);
		ViewAddress_TextField.setEditable(false);
		ViewPostalCode_TextField.setEditable(false);
		ViewProvince_TextField.setEditable(false);
		ViewPhoneNumber_TextField.setEditable(false);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = getCreatedConn();

			Statement retrieveStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSetPlayer = retrieveStatement.executeQuery("select player_id ,first_name from player");
			if (resultSetPlayer.first() == false) {
				System.out.println(">There are no records in player table");
			}

			ResultSetMetaData metaData = resultSetPlayer.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			resultSetPlayer.beforeFirst();

			players_List.clear();
			players_NameList.clear();

			while (resultSetPlayer.next()) {
				Player player;
				for (int i = 1; i <= numberOfColumns; i += 2) {
					player = new Player(Integer.parseInt(resultSetPlayer.getObject(i).toString()),
							resultSetPlayer.getObject(i + 1).toString());
					players_List.add(player);
					players_NameList.add(player.playerFirstName);
				}
			}

			players_Combo.getItems().addAll(players_NameList);
			gameResultPlayers_ComboBox.getItems().addAll(players_NameList);
			gamePlayedPlayers_ComboBox.getItems().addAll(players_NameList);

			ResultSet resultSetGame = retrieveStatement.executeQuery("select game_id ,game_title from game");
			if (resultSetGame.first() == false) {
				System.out.println(">There are no records in game table");
			}
			ResultSetMetaData metaDataGame = resultSetGame.getMetaData();
			int numberOfColumnsGame = metaDataGame.getColumnCount();

			resultSetGame.beforeFirst();

			games_List.clear();
			games_NameList.clear();

			while (resultSetGame.next()) {
				Game game;
				for (int i = 1; i <= numberOfColumnsGame; i += 2) {
					game = new Game(Integer.parseInt(resultSetGame.getObject(i).toString()),
							resultSetGame.getObject(i + 1).toString());
					games_List.add(game);
					games_NameList.add(game.gameTitle);
				}
				gamePlayed_ComboBox.getItems().addAll(games_NameList);
			}

			ResultSet resultSetPlayerGame = retrieveStatement.executeQuery("select * from PlayerAndGame");
			if (resultSetPlayerGame.first() == false) {
				System.out.println(">There are no records in PlayerAndGame table");
			}

			resultSetPlayerGame.beforeFirst();

			PlayerGameId_ListView.getItems().add("Player Game Id");
			GameId_ListView.getItems().add("Game Id");
			PlayerId_ListView.getItems().add("Player Id");
			PlayingDate_ListView.getItems().add("Date");
			Score_ListView.getItems().add("Score");

			while (resultSetPlayerGame.next()) {
				PlayerGameId_ListView.getItems().add(resultSetPlayerGame.getObject(1).toString());
				GameId_ListView.getItems().add(resultSetPlayerGame.getObject(2).toString());
				PlayerId_ListView.getItems().add(resultSetPlayerGame.getObject(3).toString());
				PlayingDate_ListView.getItems().add(resultSetPlayerGame.getObject(4).toString());
				Score_ListView.getItems().add(resultSetPlayerGame.getObject(5).toString());
			}

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	public class ViewComboHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			OnComboChange();
		}
	}

	public class ViewEditButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			OnEdit();

		}
	}

	public class ViewUpdateButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			OnUpdate();
		}
	}

	public class AddPlayerAddButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			playerAddButton();
		}
	}

	public class AddGameAddButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			gameAddButton();
		}
	}

	public class GamePlayedRecordHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			gamePlayedRecord();
		}
	}

	public class GamePlayedFilterButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			gpFilterButton();
		}
	}

	@FXML
	private void OnComboChange() {
		int selectedPlayerId = -1;
		if (players_Combo.getValue() != null) {
			for (int index = 0; index < players_List.size(); index++) {
				if (players_Combo.getValue() == players_List.get(index).playerFirstName) {
					selectedPlayerId = players_List.get(index).playerId;
					break;
				}
			}
			System.out.println(">Selected Player Id:" + selectedPlayerId);
			Connection connection = getCreatedConn();
			try {
				PreparedStatement preStatement = connection.prepareStatement("Select * from player where player_id=?");
				System.out.println(">==================================\n");
				preStatement.setInt(1, selectedPlayerId);
				ResultSet result = preStatement.executeQuery();
				while (result.next()) {
					System.out.println(result.getObject(1).toString());
					ViewPlayerId_TextField.setText(result.getObject(1).toString());
					ViewFirstName_TextField.setText(result.getObject(2).toString());
					ViewLastName_TextField.setText(result.getObject(3).toString());
					ViewAddress_TextField.setText(result.getObject(4).toString());
					ViewPostalCode_TextField.setText(result.getObject(5).toString());
					ViewProvince_TextField.setText(result.getObject(6).toString());
					ViewPhoneNumber_TextField.setText(result.getObject(7).toString());
				}
				connection.close();
			} catch (Exception e) {
				System.out.print(">Exception: " + e.getMessage());
			}
		}
	}

	@FXML
	private void OnEdit() {
		System.out.print(">Edit Button Clicked ");

		ViewFirstName_TextField.setEditable(true);
		ViewLastName_TextField.setEditable(true);
		ViewAddress_TextField.setEditable(true);
		ViewPostalCode_TextField.setEditable(true);
		ViewProvince_TextField.setEditable(true);
		ViewPhoneNumber_TextField.setEditable(true);
	}

	@FXML
	private void OnUpdate() {
		System.out.print(">Update Button Clicked ");

		ViewPlayerId_TextField.setEditable(false);
		ViewFirstName_TextField.setEditable(false);
		ViewLastName_TextField.setEditable(false);
		ViewAddress_TextField.setEditable(false);
		ViewPostalCode_TextField.setEditable(false);
		ViewProvince_TextField.setEditable(false);
		ViewPhoneNumber_TextField.setEditable(false);
		Connection connection = getCreatedConn();

		try {
			PreparedStatement preStatement = connection.prepareStatement(
					"Update Player set first_Name = ? ,last_Name = ? ,address = ? ,postal_Code = ?, province = ? , phone_Number = ?  where player_id=?");
			System.out.println(">==================================");
			preStatement.setString(1, ViewFirstName_TextField.getText());
			preStatement.setString(2, ViewLastName_TextField.getText());
			preStatement.setString(3, ViewAddress_TextField.getText());
			preStatement.setString(4, ViewPostalCode_TextField.getText());
			preStatement.setString(5, ViewProvince_TextField.getText());
			preStatement.setString(6, ViewPhoneNumber_TextField.getText());
			preStatement.setString(7, ViewPlayerId_TextField.getText());

			preStatement.executeQuery();
			System.out.println(">Update Was Successful ");

			connection.close();
		} catch (Exception e) {
			System.out.print(">Exception:" + e.getMessage());
		}
	}

	@FXML
	private void playerAddButton() {
		Connection connection = getCreatedConn();

		if (addFirstName_TextField.getText() != null && addFirstName_TextField.getText() != ""
				&& addLastName_TextField.getText() != null && addLastName_TextField.getText() != ""
				&& addAddress_TextField.getText() != null && addAddress_TextField.getText() != ""
				&& addPostalCode_TextField.getText() != null && addPostalCode_TextField.getText() != ""
				&& addProvince_TextField.getText() != null && addProvince_TextField.getText() != ""
				&& addPhoneNumber_TextField.getText() != null && addPhoneNumber_TextField.getText() != "") {

			try {
				PreparedStatement preStatement = connection.prepareStatement(
						"insert into Player (player_id ,first_Name  ,last_Name  ,address  ,postal_Code , province  , phone_Number) values(player_id_sequence.NEXTVAL,?,?,?,?,?,?)");
				System.out.println(">==================================");
				preStatement.setString(1, addFirstName_TextField.getText());
				preStatement.setString(2, addLastName_TextField.getText());
				preStatement.setString(3, addAddress_TextField.getText());
				preStatement.setString(4, addPostalCode_TextField.getText());
				preStatement.setString(5, addProvince_TextField.getText());
				preStatement.setString(6, addPhoneNumber_TextField.getText());

				preStatement.executeQuery();
				System.out.println(">Update was Successful ");
				addPlayerMessage.setText("Player Added");
				addFirstName_TextField.setText("");
				addLastName_TextField.setText("");
				addAddress_TextField.setText("");
				addPostalCode_TextField.setText("");
				addProvince_TextField.setText("");
				addPhoneNumber_TextField.setText("");

				connection.close();
			} catch (Exception e) {
				System.out.print(">Exception:" + e.getMessage());
			}
		}

	}

	@FXML
	private void gameAddButton() {
		Connection connection = getCreatedConn();

		if (GameName_TextField.getText() != null && GameName_TextField.getText() != "") {
			try {
				PreparedStatement preStatement = connection
						.prepareStatement("insert into Game (game_id ,game_title) values (game_id_sequence.NEXTVAL,?)");
				preStatement.setString(1, GameName_TextField.getText().toString());

				preStatement.executeQuery();
				System.out.println(">==================================");
				System.out.println(">Update Was Successful ");
				AddGameMessage.setText("Game Added");
				GameName_TextField.setText("");

				connection.close();
			} catch (Exception e) {
				System.out.print(">Exception:" + e);
			}
		}

	}

	@FXML
	private void gamePlayedRecord() {
		int selectedPlayerId = -1;
		for (int index = 0; index < players_List.size(); index++) {
			if (gamePlayedPlayers_ComboBox.getValue() == players_List.get(index).playerFirstName) {
				selectedPlayerId = players_List.get(index).playerId;
				break;
			}
		}

		int selectedGameId = -1;
		for (int index = 0; index < games_List.size(); index++) {
			if (gamePlayed_ComboBox.getValue() == games_List.get(index).gameTitle) {
				selectedGameId = games_List.get(index).gameId;
				break;
			}
		}

		java.util.Date date = java.util.Date
				.from(gamePlayed_DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		Connection connection = getCreatedConn();
		try {
			PreparedStatement preStatement = connection.prepareStatement(
					"insert into PlayerAndGame ( player_game_id ,game_id ,player_id ,playing_date, score ) values (playergame_id_sequence.NEXTVAL,?,?,?,?)");

			preStatement.setInt(1, selectedGameId);
			preStatement.setInt(2, selectedPlayerId);
			preStatement.setDate(3, sqlDate);
			preStatement.setString(4, gamePlayedScore.getText());

			preStatement.executeQuery();
			System.out.println(">Insert Was Successful");

			connection.close();
		} catch (Exception e) {
			System.out.print(">Exception:" + e.getMessage());
		}
	}

	@FXML
	private void gpFilterButton() {
		PlayerGameId_ListView.getItems().clear();
		GameId_ListView.getItems().clear();
		PlayerId_ListView.getItems().clear();
		PlayingDate_ListView.getItems().clear();
		Score_ListView.getItems().clear();

		if (gameResultPlayers_ComboBox.getValue() != null && gameResultStart_DatePicker.getValue() != null
				&& gameResultEnd_DatePicker.getValue() != null) {
			System.out.println(">================================== Filter - Player and Dates");
			int selectedPlayerId = -1;
			for (int index = 0; index < players_List.size(); index++) {
				if (gameResultPlayers_ComboBox.getValue() == players_List.get(index).playerFirstName) {
					selectedPlayerId = players_List.get(index).playerId;
					break;
				}
			}

			java.util.Date startDate = java.util.Date
					.from(gameResultStart_DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());

			java.util.Date endDate = java.util.Date
					.from(gameResultEnd_DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

			Connection connection = getCreatedConn();
			try {
				PreparedStatement preStatement = connection.prepareStatement(
						"select * from PlayerAndGame where playing_date >= ? and playing_date <= ? and player_id = ? ");

				preStatement.setDate(1, sqlStartDate);
				preStatement.setDate(2, sqlEndDate);
				preStatement.setInt(3, selectedPlayerId);

				ResultSet result = preStatement.executeQuery();

				PlayerGameId_ListView.getItems().add("Player Game Id");
				GameId_ListView.getItems().add("Game Id");
				PlayerId_ListView.getItems().add("Player Id");
				PlayingDate_ListView.getItems().add("Date");
				Score_ListView.getItems().add("Score");

				while (result.next()) {
					PlayerGameId_ListView.getItems().add(result.getObject(1).toString());
					GameId_ListView.getItems().add(result.getObject(2).toString());
					PlayerId_ListView.getItems().add(result.getObject(3).toString());
					PlayingDate_ListView.getItems().add(result.getObject(4).toString());
					Score_ListView.getItems().add(result.getObject(5).toString());
				}
				connection.close();
			} catch (Exception e) {
				System.out.print(">Exception:" + e.getMessage());
			}
		} else if (gameResultPlayers_ComboBox.getValue() != null && gameResultStart_DatePicker.getValue() == null
				&& gameResultEnd_DatePicker.getValue() == null) {
			System.out.println(">================================== Filter - Player only");
			int selectedPlayerId = -1;
			for (int index = 0; index < players_List.size(); index++) {
				if (gameResultPlayers_ComboBox.getValue() == players_List.get(index).playerFirstName) {
					selectedPlayerId = players_List.get(index).playerId;
					break;
				}
			}

			Connection connection = getCreatedConn();
			try {
				PreparedStatement preStatement = connection
						.prepareStatement("select * from PlayerAndGame where player_id = ? ");

				preStatement.setInt(1, selectedPlayerId);

				ResultSet result = preStatement.executeQuery();

				PlayerGameId_ListView.getItems().add("Player Game Id");
				GameId_ListView.getItems().add("Game Id");
				PlayerId_ListView.getItems().add("Player Id");
				PlayingDate_ListView.getItems().add("Date");
				Score_ListView.getItems().add("Score");

				while (result.next()) {
					PlayerGameId_ListView.getItems().add(result.getObject(1).toString());
					GameId_ListView.getItems().add(result.getObject(2).toString());
					PlayerId_ListView.getItems().add(result.getObject(3).toString());
					PlayingDate_ListView.getItems().add(result.getObject(4).toString());
					Score_ListView.getItems().add(result.getObject(5).toString());
				}
				connection.close();
			} catch (Exception e) {
				System.out.print(">Exception:" + e.getMessage());
			}
		}
	}

	private Connection getCreatedConn() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("> Driver Loaded successfully.");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD",
					"COMP122M20_003_P_72", "password");

			System.out.println(">Database connected successfully.");

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

	class Player {
		public int playerId;
		public String playerFirstName;

		Player(int playerId, String playerFirstName) {
			this.playerId = playerId;
			this.playerFirstName = playerFirstName;
		}

	}

	class Game {
		public int gameId;
		public String gameTitle;

		Game(int gameId, String gameTitle) {
			this.gameId = gameId;
			this.gameTitle = gameTitle;
		}
	}

	class PlayerAndGame {
		private String playerGameId;
		private String gameId;
		private String playerId;
		private String playingDate;
		private String score;

		public String getplayerGameId() {
			return playerGameId;
		}

		public void setplayerGameId(String playerGameId) {
			this.playerGameId = playerGameId;
		}

		public String getgameId() {
			return gameId;
		}

		public void setgameId(String gameId) {
			this.gameId = gameId;
		}

		public String getplayerId() {
			return playerId;
		}

		public void setplayerId(String playerId) {
			this.playerId = playerId;
		}

		public String getplaying_Date() {
			return playingDate;
		}

		public void setplaying_Date(String playingDate) {
			this.playingDate = playingDate;
		}

		public String getscore() {
			return score;
		}

		public void setscore(String score) {
			this.score = score;
		}

		public PlayerAndGame(String playerGameId, String gameId, String playerId, String playingDate, String score) {
			super();
			this.playerGameId = playerGameId;
			this.gameId = gameId;
			this.playerId = playerId;
			this.playingDate = playingDate;
			this.score = score;
		}

		@Override
		public String toString() {
			return "PlayerAndGame [playerGameId=" + playerGameId + ", gameId=" + gameId + ", playerId=" + playerId
					+ ", playingDate=" + playingDate + ", score=" + score + "]";
		}

	}
}