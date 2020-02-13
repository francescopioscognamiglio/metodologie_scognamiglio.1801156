package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.model.Answer;
import it.uniroma1.fabbricasemantica.model.Data;
import it.uniroma1.fabbricasemantica.model.Task;

/**
 * Servlet che permette di generare e salvare i dati per il task Translation Annotation
 * @author francescopioscognamiglio
 */
@WebServlet(name = "TaskTranslationAnnotationServlet", urlPatterns = "/translationAnnotation.jsp")
public class TaskTranslationAnnotationServlet extends BaseTaskServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("task") != null) {
			super.getData(request, response);
			return;
		}

		if (request.getParameter("submit_button") != null) {
			List<Data> data = new ArrayList<>();
			data.add(new Data(request.getParameter("word")));
			data.add(new Data(request.getParameter("description")));

			List<Answer> answers = new ArrayList<>();
			answers.add(new Answer(request.getParameter("answer")));

			Task task = new Task(StandardTask.TRANSLATION_ANNOTATION.getTaskID(), data, answers);

			super.submit(request, task);
		}

		response.sendRedirect("wordAnnotation.html");
	}
}