// Función para verificar si un elemento está visible en pantalla
function isElementInViewport(element) {
    var rect = element.getBoundingClientRect();
    return (
        rect.top >= 0 &&
        rect.left >= 0 &&
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
}

// Función para aplicar el efecto de Fade In a los elementos visibles en pantalla
function fadeInElementsOnScroll() {
    var elements = document.querySelectorAll('.fade-in');
    elements.forEach(function (element) {
        if (isElementInViewport(element) && !element.classList.contains('fade-in-animation')) {
            element.classList.add('fade-in-animation');
        }
    });
}

// Evento para aplicar el efecto de Fade In cuando se hace scroll en la página
window.addEventListener('scroll', fadeInElementsOnScroll);
window.addEventListener('resize', fadeInElementsOnScroll);
window.addEventListener('DOMContentLoaded', fadeInElementsOnScroll);

// Evento para aplicar el efecto de Fade In cuando se hace scroll en la página
window.addEventListener('scroll', function() {
    var navigation = document.querySelector('.navigation');
    if (window.scrollY > 0) {
        navigation.classList.add('scrolled');
    } else {
        navigation.classList.remove('scrolled');
    }
});

