window.sr = ScrollReveal();

// ANIMATIONS WITH USER SCROLL THE SCREEN
sr.reveal('.other_products', {
    duration: 1500,
    origin: 'bottom',
    reset: 'true'
});

document.getElementById("reservation-form").addEventListener("submit", function (event) {
    event.preventDefault();
    const bandName = document.getElementById("band-name").value;
    const eventDate = document.getElementById("event-date").value;
    const contactEmail = document.getElementById("contact-email").value;
    const additionalComments = document.getElementById("additional-comments").value;
    alert(`Nombre: ${bandName}\nFecha requerida: ${eventDate}\nCorreo de Contacto: ${contactEmail}\nComentarios Adicionales: ${additionalComments}`);
});