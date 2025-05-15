package es.uned.lsi.eped.pract2024_2025;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.IteratorIF;

public class TaskPlannerSequence implements TaskPlannerIF {

	/*
	 * Declaración de atributos para almacenar la información del planificador de
	 * tareas
	 */

	/* Estructura que almacena las tareas pasadas */
	protected List<TaskIF> pastTasks;
	/* La estructura que almacena las tareas futuras debe ser una secuencia */
	protected List<TaskIF> futureTasks;

	public TaskPlannerSequence() {
		pastTasks = new List<TaskIF>();
		futureTasks = new List<TaskIF>();
	}

	public TaskPlannerSequence(List<TaskIF> pastTasks, List<TaskIF> futureTasks) {
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
		Task newTask = new Task(text, date);

		if (futureTasks.isEmpty()) {
			futureTasks.insert(1, newTask);
			return;
		}

		for (int i = 1; i <= futureTasks.size(); i++) {
			TaskIF currentTask = futureTasks.get(i);
			if (currentTask.getDate() == date) {
				System.out.println("Ya hay una tarea programada para esta fecha");
				return;
			}
			if (currentTask.getDate() > date) {
				futureTasks.insert(i, newTask);
				return;
			}
		}

		futureTasks.insert(futureTasks.size() + 1, newTask);
	}

	/*
	 * Elimina una tarea
	 * 
	 * @param date: fecha de la tarea que se debe eliminar
	 */
	public void delete(int date) {
		for (int i = 1; i <= futureTasks.size(); i++) {
			switch (Integer.compare(date, futureTasks.get(i).getDate())) {
				case 0:
					futureTasks.remove(i);
					System.out.println("Tarea eliminada correctamente");
					return;
				case 1:
					continue;
				case -1:
					break;
			}
		}

		System.out.println("Ninguna tarea encontrada para esta fecha");
	}

	/*
	 * Reprograma una tarea
	 * 
	 * @param origDate: fecha actual de la tarea
	 * 
	 * @param newDate: nueva fecha de la tarea
	 */
	public void move(int origDate, int newDate) {
		if (futureTasks.isEmpty()) {
			System.out.println("No hay tareas futuras para reprogramar");
			return;
		}

		if (newDate < 0) {
			System.out.println("La nueva fecha no puede ser negativa");
			return;
		}

		for (int i = 1; i <= futureTasks.size(); i++) {
			if (futureTasks.get(i).getDate() == newDate) {
				System.out.println("Ya hay una tarea programada para la nueva fecha");
				return;
			}
		}

		for (int i = 1; i <= futureTasks.size(); i++) {
			if (futureTasks.get(i).getDate() == origDate) {
				TaskIF task = futureTasks.get(i);
				futureTasks.remove(i);
				add(task.getText(), newDate);
				return;
			}
		}

		System.out.println("No se ha encontrado ninguna tarea con la fecha especificada");
	}

	/*
	 * Ejecuta la próxima tarea:
	 * la mete en el histórico marcándola como completada
	 */
	public void execute() {
		if (futureTasks.isEmpty()) {
			System.out.println("No hay tareas futuras para ejecutar");
			return;
		}

		TaskIF task = futureTasks.get(1);
		futureTasks.remove(1);
		task.setCompleted();
		insertInPastTasks(task);
	}

	/*
	 * Descarta la próxima tarea:
	 * la mete en el histórico marcándola como no completada
	 */
	public void discard() {
		if (futureTasks.isEmpty()) {
			System.out.println("No hay tareas futuras para descartar");
			return;
		}

		TaskIF task = futureTasks.get(1);
		futureTasks.remove(1);
		insertInPastTasks(task);
	}

	/* Devuelve un iterador de las tareas futuras */
	public IteratorIF<TaskIF> iteratorFuture() {
		return futureTasks.iterator();
	}

	/* Devuelve un iterador del histórico de tareas pasadas */
	public IteratorIF<TaskIF> iteratorPast() {
		return pastTasks.iterator();
	}

	/* Inserta una tarea en el histórico de tareas pasadas */
	private void insertInPastTasks(TaskIF task) {
		for (int i = 1; i <= pastTasks.size(); i++) {
			if (task.getDate() < pastTasks.get(i).getDate()) {
				pastTasks.insert(i, task);
				return;
			}
		}
		pastTasks.insert(pastTasks.size() + 1, task);
	}
}
