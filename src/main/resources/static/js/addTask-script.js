document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".add-task-form form");

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const toDo = document.getElementById("toDo").value.trim();
        const priority = document.getElementById("priority").value;
        const toDoDate = document.getElementById("toDoDate").value;

        if (!toDo || !priority || !toDoDate) {
            alert("Please fill in all fields.");
            return;
        }

        const task = {
            toDo: toDo,
            priority: priority,
            toDoDate: toDoDate
        };

        console.log("Captured Task:", task);

        fetch(`${API_BASE_URL}/api/task/add`, {
            method: "POST",
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
                console.log("Task added:", data);
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
