window.sr = ScrollReveal();

document.getElementById("reservation-form").addEventListener("submit", function (event) {
    event.preventDefault();
    const bandName = document.getElementById("band-name").value;
    const eventDate = document.getElementById("event-date").value;
    const contactEmail = document.getElementById("contact-email").value;
    const additionalComments = document.getElementById("additional-comments").value;
    alert(`Nombre: ${bandName}\nFecha requerida: ${eventDate}\nCorreo de Contacto: ${contactEmail}\nComentarios Adicionales: ${additionalComments}`);
});

function myFunction() {
    document.getElementById("demo1").innerHTML =
        "Cookies associated with this document: " + document.cookie;
}

document.getElementById("demo2").innerHTML =
    "Number of anchors are: " + document.anchors.length;

document.getElementById("demo3").innerHTML =
    "Number of links: " + document.links.length;

document.getElementById("demo4").innerHTML =
    "Number of forms: " + document.forms.length;

document.getElementById("demo5").innerHTML =
    "Number of images: " + document.images.length;

function disableElement() {
    document.getElementById("btn01").disabled = true;
}

function myFunction1() {
    var x = document.getElementById("btn1").innerHTML;
    document.getElementById("demo6").innerHTML = x;
}

function myFunction2() {
    var x = document.getElementById("frm1");
    var text = "";
    var i;
    for (i = 0; i < x.length; i++) {
        text += x.elements[i].value + "<br>";
    }
    document.getElementById("demo7").innerHTML = text;
}

function myFunction3() {
    var x = document.getElementById("myAnchor").href;
    document.getElementById("demo8").innerHTML = x;
}

function myFunction4() {
    var x = document.getElementById("myframe");
    x.style.backgroundColor = "red";
}

function changeContent(id, row, cell, content) {
    var x = document.getElementById(id).rows[row].cells;
    x[cell].innerHTML = content;
}

// ANIMATIONS WITH USER SCROLL THE SCREEN
sr.reveal('.other_products', {
    duration: 1500,
    origin: 'bottom',
    reset: 'true'
});

sr.reveal('.exercise-container', {
    duration: 1500,
    origin: 'bottom',
    reset: 'true'
});