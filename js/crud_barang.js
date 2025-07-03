let selectedRow = null;

function onFormSubmit(event) {
  event.preventDefault();
  const formData = readFormData();
  if (selectedRow == null) {
    insertNewRecord(formData);
  } else {
    updateRecord(formData);
  }
  resetForm();
}

function readFormData() {
  return {
    id_barang: document.getElementById("id_barang").value,
    nama: document.getElementById("nama").value,
    jenis: document.getElementById("jenis").value,
    stok: document.getElementById("stok").value,
    harga: document.getElementById("harga").value,
    garansi: document.getElementById("garansi").value
  };
}

function insertNewRecord(data) {
  const table = document.getElementById("barangTable").getElementsByTagName("tbody")[0];
  const newRow = table.insertRow();
  newRow.insertCell(0).innerHTML = data.id_barang;
  newRow.insertCell(1).innerHTML = data.nama;
  newRow.insertCell(2).innerHTML = data.jenis;
  newRow.insertCell(3).innerHTML = data.stok;
  newRow.insertCell(4).innerHTML = data.harga;
  newRow.insertCell(5).innerHTML = data.garansi;
  newRow.insertCell(6).innerHTML = `
    <button onclick="onEdit(this)">Edit</button>
    <button onclick="onDelete(this)">Delete</button>
  `;
}

function onEdit(button) {
  selectedRow = button.parentElement.parentElement;
  document.getElementById("id_barang").value = selectedRow.cells[0].innerHTML;
  document.getElementById("nama").value = selectedRow.cells[1].innerHTML;
  document.getElementById("jenis").value = selectedRow.cells[2].innerHTML;
  document.getElementById("stok").value = selectedRow.cells[3].innerHTML;
  document.getElementById("harga").value = selectedRow.cells[4].innerHTML;
  document.getElementById("garansi").value = selectedRow.cells[5].innerHTML;
}

function updateRecord(formData) {
  selectedRow.cells[0].innerHTML = formData.id_barang;
  selectedRow.cells[1].innerHTML = formData.nama;
  selectedRow.cells[2].innerHTML = formData.jenis;
  selectedRow.cells[3].innerHTML = formData.stok;
  selectedRow.cells[4].innerHTML = formData.harga;
  selectedRow.cells[5].innerHTML = formData.garansi;
}

function onDelete(button) {
  if (confirm("Yakin ingin menghapus data ini?")) {
    const row = button.parentElement.parentElement;
    document.getElementById("barangTable").deleteRow(row.rowIndex);
    resetForm();
  }
}

function resetForm() {
  document.getElementById("id_barang").value = "";
  document.getElementById("nama").value = "";
  document.getElementById("jenis").value = "";
  document.getElementById("stok").value = "";
  document.getElementById("harga").value = "";
  document.getElementById("garansi").value = "";
  selectedRow = null;
}
