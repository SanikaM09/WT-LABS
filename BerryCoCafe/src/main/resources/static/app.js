const tableBody = document.getElementById('menu-table-body');
const form = document.getElementById('menu-form');

async function loadMenu() {
    const response = await fetch('/api/menu');
    const items = await response.json();

    tableBody.innerHTML = '';
    items.forEach((item) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.category}</td>
            <td>$${item.price.toFixed(2)}</td>
            <td><button onclick="deleteItem(${item.id})">Delete</button></td>
        `;
        tableBody.appendChild(row);
    });
}

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const payload = {
        name: document.getElementById('name').value,
        category: document.getElementById('category').value,
        price: parseFloat(document.getElementById('price').value)
    };

    await fetch('/api/menu', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    });

    form.reset();
    await loadMenu();
});

async function deleteItem(id) {
    await fetch(`/api/menu/${id}`, { method: 'DELETE' });
    await loadMenu();
}

loadMenu();
