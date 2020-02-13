package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.data.BabelNetDataProvider;
import it.uniroma1.fabbricasemantica.data.DataProvider;
import it.uniroma1.fabbricasemantica.data.MyTask;
import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.data.Task;
import it.uniroma1.fabbricasemantica.data.WordNetDataProvider;
import it.uniroma1.fabbricasemantica.service.ApplicationService;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che contiene le funzionalità comuni ai Task
 * @author francescopioscognamiglio
 */
public abstract class BaseTaskServlet extends BaseServlet {

	private static final long serialVersionUID = 8783416660707020469L;

	protected Map<String, Task> tasks;
	protected DataProvider<String> dataProvider;

	@Override
	public void init() throws ServletException {
		super.init();
		//dataProvider = new WordNetDataProvider();
		dataProvider = new BabelNetDataProvider();
		tasks = Arrays.stream(StandardTask.values()).collect(Collectors.toMap(Task::getTaskID, s -> s));
		tasks.putAll(Arrays.stream(MyTask.values()).collect(Collectors.toMap(Task::getTaskID, s -> s)));
	}

	protected void getData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Task task = tasks.get((String) request.getParameter("task"));
		String json = dataProvider.getData(task);
		response.getWriter().write(json);
	}

	protected void submit(HttpServletRequest request, it.uniroma1.fabbricasemantica.model.Task task) {
		ApplicationService.getInstance()
				.insertTask(task, task.getData(), task.getAnswers(), (String)request.getSession().getAttribute("username"));
	}
}
