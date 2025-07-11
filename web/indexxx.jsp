<%-- 
    Document   : index.jsp
    Created on : Jun 27, 2025, 8:25:44 PM
    Author     : edelweiss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controller.Controller_Transaksi"%>
<%@page import="Controller.Controller_Barang"%>
<%@page import="Controller.Controller_Customer"%>
<%@page import="Controller.Controller_Transaksi_barang"%>
<%@page import="model.Transaksi" %>
<%@page import="model.Transaksi_barang" %>
<%@page import="model.Barang"%>
<%@page import="model.Customer" %>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         </div>
        <table>
            <thead>
                <tr> 
                    <th>No.</th>
                    <th>Id</th>
                    <th>Nama Barang</th>
                    <th>Tanggal Pembelian</th>
                    <th>Jumlah</th>
                    <th>Harga Satuan</th>
                    <th>Vendor</th>
                    <th>Tanggal Garansi</th>
                    <th>Jenis Garansi</th>
                    <th>Penanggung Jawab</th>
                    <th>Created_at</th>
                </tr>
            </thead>
            <tbody>
                <%
                Controller_Transaksi controller = new Controller_Transaksi();
                Controller_Barang cBarang = new Controller_Barang();
                Controller_Customer cCustomer = new Controller_Customer();
                Controller_Transaksi_barang cTBarang = new Controller_Transaksi_barang();
                ArrayList<Barang> list = cBarang.getAll();
                int i = 1;
                for(Barang item:list){
                    %>
                    <tr>
                        <form method="POST" action="index.jsp" border="2" >
                            <td>
                                <%
                                    out.println(String.valueOf(i));
                                %>
                            </td>
                            <td>
                                <%
                                    out.println(item.getID_barang());
                                %>
                            </td>
                        </form>
                    </tr>
                    <%
                    i++;
                }
               Customer cst = cCustomer.getCari("1").get(0);
               Transaksi tr = new Transaksi();
               tr.setAlamat_pengiriman("Cengkareng");
               tr.setHTMLTanggal_pengiriman("2025-03-25");
               tr.setID_customer(cst.getID_customer());
               tr.setTelepon("087878402264");

               Barang brg = cBarang.getCari("1").get(0);
               Transaksi_barang trb = new Transaksi_barang();

               trb.setID_transaksi(tr.getID_transaksi());
               trb.setHarga_satuan(brg.getHarga_barang());
               trb.setID_barang(brg.getID_barang());
               trb.setJumlah_pembelian(10);
               trb.setLama_garansi(brg.getLama_garansi());
               ArrayList<Transaksi_barang> listed = new ArrayList<>();
               listed.add(trb);
                
               controller.insertNewTransaksiDanTransaksiBarang(tr, listed);
                %>
            </tbody>
        </table>
        <%
    %>


    </body>
</html>
<script>

</script>