const username = document.getElementById("login");
const password = document.getElementById("password");
const form = document.querySelector("form");
const errorMessage = document.getElementById("errorMessage");
const passw = /(?=.*[0-9]){6,}/g;

form.addEventListener("submit", (e) => {
    const errors = [];

    if (username.value.trim() === "") {
        errors.push("login required")
    }
    if (!password.value.match(passw)) {
        errors.push("password is too easy")
    }

    if (errors.length > 0) {
        e.preventDefault();
        errorMessage.toggleAttribute('hidden');
        errorMessage.innerText = errors.join(", ");
    }
})