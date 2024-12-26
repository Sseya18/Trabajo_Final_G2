document.addEventListener('DOMContentLoaded', async () => {
    const token = localStorage.getItem('token');
    if (!token) {
        alert('No estás autenticado. Redirigiendo al login...');
        window.location.href = '/index.html';
        return;
    } 
    try {
        // Verificar el token con el backend
        const response = await fetch('/auth/validate-token', {
            method: 'GET',
            headers: {
                Authorization: `Bearer ${token}`,
                },
            });

            if (!response.ok) {
                throw new Error('Token inválido');
            }
        } catch (error) {
        alert('Token inválido o expirado. Redirigiendo al login...');
        localStorage.removeItem('token');
        window.location.href = '/index.html';
        }
    
});

// Cerrar sesión
document.querySelector('.btn-exit-system').addEventListener('click', () => {
    localStorage.removeItem('token'); // Elimina el token
    window.location.href = '/index.html'; // Redirige al login
});