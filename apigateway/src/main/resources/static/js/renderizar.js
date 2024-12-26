function renderizar(){
    const nombre = localStorage.getItem('nombre');
    console.log(nombre);
    const operador = localStorage.getItem('operador');
    console.log(operador);
    const apellido = localStorage.getItem('apellido');
    console.log(apellido);
    document.getElementById('nombre').textContent = nombre + ' ' + apellido;
    document.getElementById('operador').textContent = operador;

}
window.addEventListener('DOMContentLoaded',renderizar,false)