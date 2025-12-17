const API = "http://localhost:8080"

async function loadCategories() {
    const res = await fetch (`${API}/api/categories`)
    const categories = await res.json();

    const select = document.getElementById("tx-category");
    select.innerHTML = "";

    categories.forEach(c => {
       const option = document.createElement("option");
       option.value = c.id;
       option.textContent = c.name;
       select.appendChild(option);
    });
}

async function createCategory() {
    const name = document.getElementById("cat-name").value;
    const description = document.getElementById("cat-desc").value;

    await fetch (`${API}/api/categories`, {
       method: "POST",
       headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ name, description })
    });

    await loadCategories();
}

async function createTransaction() {
    const description = document.getElementById("tx-desc").value;
    const value = document.getElementById("tx-value").value;
    const categoryId = document.getElementById("tx-category").value;

    await fetch (`${API}/transactions`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            description,
            value,
            categoryId
        })
    });

    await loadTransactions();
}

async function loadTransactions() {
    const res = await fetch (`${API}/transactions`);
    const txs = await res.json();

    const table = document.getElementById("tx-table");
    table.innerHTML = "";

    txs.forEach(t => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${t.description}</td>
            <td>${t.value}</td>
            <td>${t.category?.name ?? "-"}</td>
            <td>${new Date(t.date).toLocaleDateString()}</td>
        `;

        table.appendChild(row);
    })
}

window.createCategory = createCategory;
window.createTransaction = createTransaction;
