document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("editTaskForm");

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const taskId = document.getElementById("taskId").value;
        const toDo = document.getElementById("toDo").value;
        const priority = document.getElementById("priority").value;
        const toDoDate = document.getElementById("toDoDate").value;

        const task = {
            id: taskId,
            toDo: toDo,
            priority: priority,
            toDoDate: toDoDate
        };

        fetch(`${API_BASE_URL}/api/task/update`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(task)
        })
        .then(res => {
            if (!res.ok) {
                if (res.status === 400)
                    throw new Error("Due date cannot be in the past.");
                else
                    throw new Error("Something went wrong. Try Again.");
            }
            return res.json();
        })
        .then(data => {
            console.log("Task Updated Successfully");
            console.log(data);
            window.location.href = "/dashboard";
        })
        .catch(err => showError(err.message));

        function showError(message) {
            const errorDiv = document.getElementById("error-msg");
            if (errorDiv) {
                errorDiv.textContent = message;
                errorDiv.style.display = "block";
            } else {
                alert(message);
            }
        }
    });
});
