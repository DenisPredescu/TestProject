package CreateAccount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import extentReport.testBase.TestBase;

public class TestEmail extends TestBase {
	// if(messages.equals(folder.search(new SubjectTerm("rankingCoach Anmeldung"),
	// folder.getMessages())))

	public static void main(String[] args) throws Exception {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", "doesam848@gmail.com", "test12345678");

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		System.out.println("Total Message:" + folder.getMessageCount());
		System.out.println("Unread Message:" + folder.getUnreadMessageCount());

		Message[] messages = null;
		boolean isMailFound = false;
		Message mailFromGod = null;
		
		
		// Search for mail from God
		for (int i = 0; i < 5; i++) {
				messages = folder.search(new SubjectTerm("rankingCoach Anmeldung"), folder.getMessages());
				if (messages.length == 0) {
					Thread.sleep(10000);
				}
			/// messages = folder.search(new SubjectTerm("Registrazione rankingCoach"), folder.getMessages());
		}

		// Search for unread mail from God
		// This is to avoid using the mail for which
		// Registration is already done
		for (Message mail : messages) {
			if (!mail.isSet(Flags.Flag.SEEN)) {
				mailFromGod = mail;
				System.out.println("Message Count is: " + mailFromGod.getMessageNumber());
				isMailFound = true;
			}
		}

		// Test fails if no unread mail was found from God
		if (!isMailFound) {
			throw new Exception("Could not find RankingCoach verification email");

			// Read the content of mail and launch registration URL
		} else {
			String line;
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(mailFromGod.getInputStream()));
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			System.out.println(buffer);

			// Your logic to split the message and get the Registration URL goes here
			String registrationURL = buffer.toString().split(
					"class=\"button\"       style=\"background:#64d24c;border-color:#64d24c;border-radius:3px;border-style:solid;border-width:15px 25px;color:#ffffff;display:inline-block;font-family:'Roboto',Helvetica,Arial,sans-serif;font-size:15px;font-weight:bold;text-decoration:none\">        Klicke hier, um fortzufahren </a></div><p style=\"color: #666666;font-family: 'Roboto',Helvetica, Arial, sans-serif;font-weight: 400;padding: 10px 0;font-size: 16px;line-height: 27px;\">    Sollte der obenstehende Link nicht funktionieren, kopiere den folgenden Link und füge ihn in deine Browser-Adresszeile ein:    <br/>    <a style=\"color:#4ec1fe;\" target=\"_blank\" ")[0]
							.split("href=")[1];
			// Remove quotes from your URL : "URL"-> this url will not be validated
			String URL = registrationURL.replace("\"", "");
			System.out.println("Registration Url is: " + URL);

			driver.get(URL);

		}
	}

	public static void mainIT (String[] args) throws Exception {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", "doesam848@gmail.com", "test12345678");

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		System.out.println("Total Message:" + folder.getMessageCount());
		System.out.println("Unread Message:" + folder.getUnreadMessageCount());

		Message[] messages = null;
		boolean isMailFound = false;
		Message mailFromGod = null;
		
		
		// Search for mail from God
		for (int i = 0; i < 5; i++) {
				messages = folder.search(new SubjectTerm("Registrazione rankingCoach"), folder.getMessages());
				if (messages.length == 0) {
					Thread.sleep(10000);
				}
			/// messages = folder.search(new SubjectTerm("Registrazione rankingCoach"), folder.getMessages());
		}

		// Search for unread mail from God
		// This is to avoid using the mail for which
		// Registration is already done
		for (Message mail : messages) {
			if (!mail.isSet(Flags.Flag.SEEN)) {
				mailFromGod = mail;
				System.out.println("Message Count is: " + mailFromGod.getMessageNumber());
				isMailFound = true;
			}
		}

		// Test fails if no unread mail was found from God
		if (!isMailFound) {
			throw new Exception("Could not find new mail from God :-(");

			// Read the content of mail and launch registration URL
		} else {
			String line;
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(mailFromGod.getInputStream()));
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			System.out.println(buffer);

			// Your logic to split the message and get the Registration URL goes here
			String registrationURL = buffer.toString().split(
					"class=\"button\"       style=\"background:#64d24c;border-color:#64d24c;border-radius:3px;border-style:solid;border-width:15px 25px;color:#ffffff;display:inline-block;font-family:'Roboto',Helvetica,Arial,sans-serif;font-size:15px;font-weight:bold;text-decoration:none\">        CLICCA QUI PER TERMINARE LA REGISTRAZIONE </a></div><p style=\"color: #666666;font-family: 'Roboto',Helvetica, Arial, sans-serif;font-weight: 400;padding: 10px 0;font-size: 16px;line-height: 27px;\">    Se il link qui sopra non funziona, copialo e incollalo nel tuo browser:    <br/>    <a style=\"color:#4ec1fe;\" target=\"_blank\" ")[0]
							.split("href=")[1];

			System.out.println(registrationURL);
			// Remove quotes from your URL : "URL"-> this url will not be validated
			String URL = registrationURL.replace("\"", "");
			System.out.println("Registration Url is: " + URL);

			driver.get(URL);

		}
	}

}
