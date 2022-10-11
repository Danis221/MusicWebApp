const name = document.getElementById("name");
const link = document.getElementById("videoFromYouTube");
const form = document.querySelector("form");
const errorMessage = document.getElementById("errorMessage");
const regex = /http(?:s?):\/\/(?:www\.)youtube*/g;
const text = document.getElementById("text");

form.addEventListener("submit", (e) => {
    const errors = [];

    if (!link.value.match(regex)) {
        errors.push("this link is not from youtube11")
    }


    if (name.value.trim() === "" || name.value.trim() == null ) {
        errors.push("name article required")
    }

    if (text.value.trim() === "" || text.value.trim() == null) {
        errors.push("text required")
    }
    console.log(name.value.trim(), text.value.trim(), errors.length)
    if (errors.length > 0) {
        e.preventDefault();
        errorMessage.toggleAttribute('hidden');
        errorMessage.innerText = errors.join(", ");
    }
})
