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

        fetch("http://localhost:8082/api/task/update", {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(task)
        })
            .then(res => {
                if (!res.ok) throw new Error("Network Error");
                return res.json();
            })
            .then(data => {
                console.log("Task Updated Successfully");
                console.log(data);
                window.location.href = "/dashboard";
            })
            .catch(error => {
                console.error("Error:", error);
                alert("Could not update the task.");
            });
    });
});
