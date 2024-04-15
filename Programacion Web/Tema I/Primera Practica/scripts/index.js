window.sr = ScrollReveal();

let ButtonMode = document.getElementById('theme-mode');
themeforbody = document.body;
themeforheader = document.getElementById('header');
themeforfooter = document.getElementById('footer');
themeforcontent_container = document.getElementById('content');

// ANIMATIONS WITH USER SCROLL THE SCREEN
sr.reveal('.other_products', {
    duration: 1500,
    origin: 'bottom',
    reset: 'true'
});

sr.reveal('#js-proyects-picture', {
    duration: 1500,
    origin: 'left',
    distance: '200px',
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

// Change theme
ButtonMode.addEventListener('click', () => {
    themeforbody.classList.toggle('body-light');
    themeforfooter.classList.toggle('footer-dark');
    themeforheader.classList.toggle('header-dark')
    themeforcontent_container.classList.toggle('content-dark');
});