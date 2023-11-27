const apiMessage = "http://localhost:8080/api/messages";
const emailInput = document.getElementById("email");
const messageInput = document.getElementById("message");
const contactBtn = document.getElementById("contactBtn");


const sendMessage = async (email, message) => {
    console.log("sto per mandare il msg")
    try {
        const response = await axios.post(apiMessage, {
            email: email,
            message: message
        });
        console.log("messaggio inviato con successo");
    } catch (error) {
        console.log("messaggio non inviato", error);
    }

}


contactBtn.addEventListener("click", (event) => {
    event.preventDefault();
    console.log("ciao ho cliccato")
    const emailValue = emailInput.value;
    const messageValue = messageInput.value;
    sendMessage(emailValue, messageValue)
})