document.getElementById("registerForm").addEventListener("submit", function(e) {
    const pass = document.getElementById("password").value;
    const confirmPass = document.getElementById("confirm-password").value;

    if (pass !== confirmPass) {
        e.preventDefault(); // Stop the form from submitting
        alert("Passwords do not match!");
    }
});
