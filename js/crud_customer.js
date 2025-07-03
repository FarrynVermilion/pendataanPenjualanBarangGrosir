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
    id: document.getElementById("id").value,
    nama: document.getElementById("nama").value,
    alamat: document.getElementById("alamat").value,
    telp: document.getElementById("telp").value
  };
}

function insertNewRecord(data) {
  const table = document.getElementById("customerTable").getElementsByTagName("tbody")[0];
  const newRow = table.insertRow();
  newRow.insertCell(0).innerHTML = data.id;
  newRow.insertCell(1).innerHTML = data.nama;
  newRow.insertCell(2).innerHTML = data.alamat;
  newRow.insertCell(3).innerHTML = data.telp;
  newRow.insertCell(4).innerHTML = `
    <button onclick="onEdit(this)">Edit</button>
    <button onclick="onDelete(this)">Delete</button>
  `;
}

function onEdit(button) {
  selectedRow = button.parentElement.parentElement;
  document.getElementById("id").value = selectedRow.cells[0].innerHTML;
  document.getElementById("nama").value = selectedRow.cells[1].innerHTML;
  document.getElementById("alamat").value = selectedRow.cells[2].innerHTML;
  document.getElementById("telp").value = selectedRow.cells[3].innerHTML;
}

function updateRecord(formData) {
  selectedRow.cells[0].innerHTML = formData.id;
  selectedRow.cells[1].innerHTML = formData.nama;
  selectedRow.cells[2].innerHTML = formData.alamat;
  selectedRow.cells[3].innerHTML = formData.telp;
}

function onDelete(button) {
  if (confirm("Yakin ingin menghapus data ini?")) {
    const row = button.parentElement.parentElement;
    document.getElementById("customerTable").deleteRow(row.rowIndex);
    resetForm();
  }
}

function resetForm() {
  document.getElementById("id").value = "";
  document.getElementById("nama").value = "";
  document.getElementById("alamat").value = "";
  document.getElementById("telp").value = "";
  selectedRow = null;
}
