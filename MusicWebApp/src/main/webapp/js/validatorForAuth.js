const username = document.getElementById("login");
const password = document.getElementById("password");
const lastname = document.getElementById("lastname");
const firstname = document.getElementById("firstname");
const form = document.querySelector("form");
const errorMessage = document.getElementById("errorMessage");
const passw = /(?=.*[0-9]){6,}/g;
const name = /^[a-zA-Zа-яА-Я'][a-zA-Zа-яА-Я-' ]+[a-zA-Zа-яА-Я']?$/u;
form.addEventListener("submit", (e) => {
    const errors = [];

    if (username.value.trim() === "") {
        errors.push("login required")
    }

    if (firstname.value.trim() === "") {
        errors.push("firstname required")
    }

    if (lastname.value.trim() === "") {
        errors.push("lastname required")
    }
    if (!password.value.match(passw)) {
        errors.push("password is too easy")
    }

    if(!username.value.match(name)) {
        errors.push("firstname is too weird")
    }

    if(!lastname.value.match(name) ) {
        errors.push("lastname is too weird")
    }

    if (errors.length > 0) {
        e.preventDefault();
        errorMessage.toggleAttribute('hidden');
        errorMessage.innerText = errors.join(",\r\n");
    }
})