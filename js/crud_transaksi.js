let selectedRow = null;
let transaksiCounter = 1;

function onFormSubmit(event) {
  event.preventDefault();
  const data = readFormData();
  if (selectedRow === null) {
    insertNewRecord(data);
  } else {
    updateRecord(data);
  }
  resetForm();
}

function readFormData() {
  return {
    id_transaksi: "TRX" + transaksiCounter++,
    id_cust: document.getElementById("id_cust").value,
    id_barang: document.getElementById("id_barang").value,
    harga: parseInt(document.getElementById("harga_satuan").value),
    jumlah: parseInt(document.getElementById("jumlah").value),
    tgl_beli: new Date().toISOString().split("T")[0],
    tgl_kirim: document.getElementById("tgl_kirim").value,
    alamat: document.getElementById("alamat").value,
    telp: document.getElementById("telp").value,
  };
}

function insertNewRecord(data) {
  const table = document.getElementById("transaksiTable").getElementsByTagName("tbody")[0];
  const newRow = table.insertRow();

  newRow.insertCell(0).innerHTML = data.id_transaksi;
  newRow.insertCell(1).innerHTML = data.id_cust;
  newRow.insertCell(2).innerHTML = data.id_barang;
  newRow.insertCell(3).innerHTML = data.harga;
  newRow.insertCell(4).innerHTML = data.jumlah;
  newRow.insertCell(5).innerHTML = data.harga * data.jumlah;
  newRow.insertCell(6).innerHTML = data.tgl_beli;
  newRow.insertCell(7).innerHTML = data.tgl_kirim;
  newRow.insertCell(8).innerHTML = data.alamat;
  newRow.insertCell(9).innerHTML = data.telp;
  newRow.insertCell(10).innerHTML = `
    <button onclick="onEdit(this)">Edit</button>
    <button onclick="onDelete(this)">Hapus</button>
  `;
}

function onEdit(button) {
  selectedRow = button.parentElement.parentElement;
  document.getElementById("id_cust").value = selectedRow.cells[1].innerHTML;
  document.getElementById("id_barang").value = selectedRow.cells[2].innerHTML;
  document.getElementById("harga_satuan").value = selectedRow.cells[3].innerHTML;
  document.getElementById("jumlah").value = selectedRow.cells[4].innerHTML;
  document.getElementById("tgl_kirim").value = selectedRow.cells[7].innerHTML;
  document.getElementById("alamat").value = selectedRow.cells[8].innerHTML;
  document.getElementById("telp").value = selectedRow.cells[9].innerHTML;
}

function updateRecord(data) {
  selectedRow.cells[1].innerHTML = data.id_cust;
  selectedRow.cells[2].innerHTML = data.id_barang;
  selectedRow.cells[3].innerHTML = data.harga;
  selectedRow.cells[4].innerHTML = data.jumlah;
  selectedRow.cells[5].innerHTML = data.harga * data.jumlah;
  selectedRow.cells[7].innerHTML = data.tgl_kirim;
  selectedRow.cells[8].innerHTML = data.alamat;
  selectedRow.cells[9].innerHTML = data.telp;
}

function onDelete(button) {
  if (confirm("Yakin ingin menghapus transaksi ini?")) {
    const row = button.parentElement.parentElement;
    document.getElementById("transaksiTable").deleteRow(row.rowIndex);
    resetForm();
  }
}

function resetForm() {
  document.getElementById("id_cust").value = "";
  document.getElementById("id_barang").value = "";
  document.getElementById("harga_satuan").value = "";
  document.getElementById("jumlah").value = "";
  document.getElementById("tgl_kirim").value = "";
  document.getElementById("alamat").value = "";
  document.getElementById("telp").value = "";
  selectedRow = null;
}
