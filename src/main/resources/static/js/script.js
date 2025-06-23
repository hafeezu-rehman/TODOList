console.log("Script loaded");

window.onload = function () {
    fetchAllTasks();
    console.log(new Date());
};

async function fetchAllTasks() {
    console.log("Fetching tasks...");
    try {
        const apiResponse = await fetch(`${API_BASE_URL}/api/task/find`);
        if (!apiResponse.ok) throw new Error("HTTP error " + apiResponse.status);
        const tasks = await apiResponse.json();
        console.log("Fetched data:", tasks);
        displayTasks(tasks);
    } catch (error) {
        console.error("Fetch failed:", error);
    }
}

function displayTasks(taskToDisplayed) {
    const highList = document.getElementById('high-list');
    const mediumList = document.getElementById('medium-list');
    const lowList = document.getElementById('low-list');
    const upcomingList = document.getElementById('upcoming-list');

    // Clear previous tasks
    highList.innerHTML = '';
    mediumList.innerHTML = '';
    lowList.innerHTML = '';
    upcomingList.innerHTML = '';

    const today = new Date();
    const yyyy = today.getFullYear();
    const mm = (today.getMonth() + 1).toString().padStart(2, '0');
    const dd = today.getDate().toString().padStart(2, '0');
    const todayFormatted = `${yyyy}-${mm}-${dd}`;

    taskToDisplayed.forEach(task => {
        const taskElement = document.createElement('div');
        taskElement.className = 'task-item';

        const taskText = document.createElement('span');
        taskText.textContent = `${task.toDo} (Due: ${task.toDoDate})`;

        const editBtn = document.createElement('button');
        editBtn.textContent = 'Edit';
        editBtn.className = 'edit-btn';
        editBtn.onclick = () => handleEdit(task);

        const doneBtn = document.createElement('button');
        doneBtn.textContent = 'Done';
        doneBtn.className = 'done-btn';
        doneBtn.onclick = () => handleDelete(task.id);

        taskElement.appendChild(taskText);
        taskElement.appendChild(editBtn);
        taskElement.appendChild(doneBtn);

        if (task.toDoDate === todayFormatted) {
            if (task.priority === "high") {
                highList.appendChild(taskElement);
            } else if (task.priority === "medium") {
                mediumList.appendChild(taskElement);
            } else if (task.priority === "low") {
                lowList.appendChild(taskElement);
            }
        } else {
            upcomingList.appendChild(taskElement);
        }
    });
}

function handleEdit(task) {
    window.location.href = `/updatetask/${task.id}`;
}

async function handleDelete(taskId) {
    if (!confirm("Are you sure you want to mark this task as done?")) return;

    try {
        const response = await fetch(`${API_BASE_URL}/api/task/delete/${taskId}`, {
            method: 'DELETE'
        });
        if (response.ok) {
            console.log(`Task ${taskId} deleted successfully`);
            fetchAllTasks(); // Refresh the list
        } else {
            throw new Error(`Failed to delete task. Status: ${response.status}`);
        }
    } catch (error) {
        console.error("Delete failed:", error);
    }
}
