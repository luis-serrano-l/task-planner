package es.uned.lsi.eped.pract2024_2025;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.BSTree;
import es.uned.lsi.eped.DataStructures.BSTreeIF;

public class TaskPlannerTree implements TaskPlannerIF {

	/*
	 * Declaración de atributos para almacenar la información del planificador de
	 * tareas
	 */

	/* Estructura que almacena las tareas pasadas */
	protected List<TaskIF> pastTasks;
	/* La estructura que almacena las tareas futuras debe ser un BSTree */
	protected BSTreeIF<TaskIF> futureTasks;

	public TaskPlannerTree() {
		pastTasks = new List<TaskIF>();
		futureTasks = new BSTree<TaskIF>();
	}

	public TaskPlannerTree(List<TaskIF> pastTasks, BSTreeIF<TaskIF> futureTasks) {
		this.pastTasks = pastTasks;
		this.futureTasks = futureTasks;
	}

	/*
	 * Añade una nueva tarea
	 * 
	 * @param text: descripción de la tarea
	 * 
	 * @param date: fecha en la que la tarea debe completarse
	 */
	public void add(String text, int date) {
		TaskIF taskWithSameDate = findNode(date, futureTasks);
		if (taskWithSameDate != null) {
			futureTasks.remove(taskWithSameDate);
		}
		TaskIF newTask = new Task(text, date);
		futureTasks.add(newTask);
	}

	/*
	 * Elimina una tarea
	 * 
	 * @param date: fecha de la tarea que se debe eliminar
	 */
	public void delete(int date) {
		TaskIF task = findNode(date, futureTasks);
		if (task != null) {
			futureTasks.remove(task);
		}
	}

	/*
	 * Reprograma una tarea
	 * 
	 * @param origDate: fecha actual de la tarea
	 * 
	 * @param newDate: nueva fecha de la tarea
	 */
	public void move(int origDate, int newDate) {
		TaskIF taskToMove = findNode(origDate, futureTasks);
		if (taskToMove != null && findNode(newDate, futureTasks) == null) {
			String taskText = taskToMove.getText();
			futureTasks.remove(taskToMove);
			futureTasks.add(new Task(taskText, newDate));
		}
	}

	/*
	 * Ejecuta la próxima tarea:
	 * la mete en el histórico marcándola como completada
	 */
	public void execute() {
		TaskIF nextTask = getNextTask();
		if (nextTask != null) {
			nextTask.setCompleted();
			pastTasks.insert(pastTasks.size() + 1, nextTask);
			futureTasks.remove(nextTask);
		}
	}

	/*
	 * Descarta la próxima tarea:
	 * la mete en el histórico marcándola como no completada
	 */
	public void discard() {
		TaskIF nextTask = getNextTask();
		if (nextTask != null) {
			pastTasks.insert(pastTasks.size() + 1, nextTask);
			futureTasks.remove(nextTask);
		}
	}

	/* Devuelve un iterador de las tareas futuras */
	public IteratorIF<TaskIF> iteratorFuture() {
		return futureTasks.iterator(BSTreeIF.IteratorModes.DIRECTORDER);
	}

	/* Devuelve un iterador del histórico de tareas pasadas */
	public IteratorIF<TaskIF> iteratorPast() {
		return pastTasks.iterator();
	}

	/* Método auxiliar para encontrar una tarea por su fecha en el árbol */
	private TaskIF findNode(int date, BSTreeIF<TaskIF> tree) {
		if (tree.isEmpty()) {
			return null;
		}

		TaskIF root = tree.getRoot();
		if (root.getDate() == date) {
			return root;
		}

		BSTreeIF<TaskIF> nextTree;
		if (date < root.getDate()) {
			nextTree = tree.getLeftChild();
		} else {
			nextTree = tree.getRightChild();
		}

		if (nextTree == null) {
			return null;
		}
		return findNode(date, nextTree);
	}

	/*
	 * Obtiene la tarea más temprana (hoja más a la izquierda) del árbol de tareas
	 * futuras
	 */
	private TaskIF getNextTask() {
		if (futureTasks.isEmpty()) {
			return null;
		}
		TaskIF taskToMove = futureTasks.getRoot();
		while (futureTasks.getLeftChild() != null) {
			taskToMove = futureTasks.getLeftChild().getRoot();
		}
		return taskToMove;
	}
}
