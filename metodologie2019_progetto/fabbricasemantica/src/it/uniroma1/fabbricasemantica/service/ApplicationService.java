package it.uniroma1.fabbricasemantica.service;

import java.util.List;

import it.uniroma1.fabbricasemantica.dao.AnswerDao;
import it.uniroma1.fabbricasemantica.dao.DataDao;
import it.uniroma1.fabbricasemantica.dao.LanguageDao;
import it.uniroma1.fabbricasemantica.dao.TaskDao;
import it.uniroma1.fabbricasemantica.dao.UserDao;
import it.uniroma1.fabbricasemantica.dao.impl.AnswerDaoImpl;
import it.uniroma1.fabbricasemantica.dao.impl.DataDaoImpl;
import it.uniroma1.fabbricasemantica.dao.impl.LanguageDaoImpl;
import it.uniroma1.fabbricasemantica.dao.impl.TaskDaoImpl;
import it.uniroma1.fabbricasemantica.dao.impl.UserDaoImpl;
import it.uniroma1.fabbricasemantica.model.Answer;
import it.uniroma1.fabbricasemantica.model.Data;
import it.uniroma1.fabbricasemantica.model.Language;
import it.uniroma1.fabbricasemantica.model.Task;
import it.uniroma1.fabbricasemantica.model.User;

/**
 * Classe che permette l'accesso al database service layer
 * @author francescopioscognamiglio
 */
public class ApplicationService {

	private static ApplicationService applicationService;

	private UserDao userDao;
	private LanguageDao languageDao;
	private TaskDao taskDao;
	private DataDao dataDao;
	private AnswerDao answerDao;

	private ApplicationService() {
		userDao = new UserDaoImpl();
		languageDao = new LanguageDaoImpl();
		taskDao = new TaskDaoImpl();
		dataDao = new DataDaoImpl();
		answerDao = new AnswerDaoImpl();
	}

	public static ApplicationService getInstance() {
		if (applicationService == null) {
			applicationService = new ApplicationService();
		}

		return applicationService;
	}

	public void insertProfile(User user) {
		userDao.createUser(user);
		for (Language language : user.getLanguages()) languageDao.createLanguage(language, user.getEmail());
	}

	public User getProfile(User user) {
		return getProfile(user.getEmail());
	}

	public User getProfile(String userEmail) {
		return userDao.getUser(userEmail);
	}

	public void insertTask(Task task, List<Data> data, List<Answer> answers, String userEmail) {
		taskDao.createTask(task, userEmail);
		for (Data d : data) dataDao.createData(d, task.getId());
		for (Answer a : answers) answerDao.createAnswer(a, task.getId());
	}
}
