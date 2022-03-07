package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * User able to chat.
 */
public class UserChat {

    public void doChat(final String userQuestion) {
        final String chatResult = "select question, answer from chatbot";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(chatResult)) {
            final String question = userQuestion;

            while (resultSet.next()) {
                final String questionResult = resultSet.getString(1);

                if (question.equalsIgnoreCase(questionResult)) {
                    System.out.println(resultSet.getString(2));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Sql Error");
        }
    }
}
