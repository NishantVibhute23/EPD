<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">


    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="assets/img/favicon.png">
        <title>
            Black Dashboard by Creative Tim
        </title>
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet" />
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <!-- Nucleo Icons -->
        <link href="assets/css/nucleo-icons.css" rel="stylesheet" />
        <!-- CSS Files -->
        <link href="assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="assets/demo/demo.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .main-panel>.content {padding-left: 30px !important; padding-top: 30px !important}
            .table-responsive {overflow: hidden !important}
            body {line-height: 0.2 !important}
            .card-body {padding-top: 0px !important;padding-bottom: 0px !important}
           .mt-100{
    margin-top:100px;
}
    
        </style>
    </head>

    <body class="">
        <div class="wrapper">

            <div class="main-panel">
                <!-- Navbar -->

                <!-- End Navbar -->
                <div class="content">
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-chart">
                                <div class="card-header ">
                                    <div class="row">
                                        <div class="col-sm-6 text-left">
                                            <h4 class="card-title">Nifty : <font color="<s:property value="indexList[indexList.size()-1].prevChange"/>"> <s:property value="indexList[indexList.size()-1].LTP"/></font></h4>
                                        </div>
                                    </div>



                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-12">
                                            <div class="card ">
                                                <div class="card-header">

                                                </div>
                                                <div class="card-body">
                                                    <div class="table-responsive">
                                                        <table class="table tablesorter " id="data1">
                                                            <thead class=" text-primary">
                                                                <tr>
                                                                    <th>
                                                                        Name
                                                                    </th>
                                                                    <th>
                                                                        LTP
                                                                    </th>
                                                                    <th>
                                                                        Change
                                                                    </th>
                                                                    <th>
                                                                        Volume
                                                                    </th>
                                                                    <th>
                                                                        Buy Price
                                                                    </th>
                                                                    <th>
                                                                        Sell Price
                                                                    </th>
                                                                    <th>
                                                                        Buy Qty
                                                                    </th>
                                                                    <th>
                                                                        Sell Qty
                                                                    </th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <s:iterator value="indexList" begin="0" end="24">
                                                                    <tr>
                                                                        <td><s:property value="companyName"/></td>

                                                                        <td >


                                                                            <font color="<s:property value="prevChange"/>"><s:property value="LTP"/></font></td>
                                                                        <td><s:property value="change"/></td>
                                                                        <td><s:property value="volume"/></td>
                                                                        <td><s:property value="buyPrice"/></td>
                                                                        <td><s:property value="sellPrice"/></td>
                                                                        <td><s:property value="buyQty"/></td>
                                                                        <td><s:property value="sellQty"/></td>
                                                                        <td>
                                                                            <a href="<s:url action="getIndexDetails"><s:param name="companyId"><s:property value="companyId"/></s:param></s:url>">  <i class="fa fa-bar-chart" style="font-size:10px;color:red"></i></a>

                                                                        </td>
                                                                    </tr>
                                                                </s:iterator>



                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-12">
                                            <div class="card ">
                                                <div class="card-header">

                                                </div>
                                                <div class="card-body">
                                                    <div class="table-responsive">
                                                        <table class="table tablesorter " id="">
                                                            <thead class=" text-primary">
                                                                <tr>
                                                                    <th>
                                                                        Name
                                                                    </th>
                                                                    <th>
                                                                        LTP
                                                                    </th>
                                                                    <th>
                                                                        Change
                                                                    </th>
                                                                    <th>
                                                                        Volume
                                                                    </th>
                                                                    <th>
                                                                        Buy Price
                                                                    </th>
                                                                    <th>
                                                                        Sell Price
                                                                    </th>
                                                                    <th>
                                                                        Buy Qty
                                                                    </th>
                                                                    <th>
                                                                        Sell Qty
                                                                    </th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <s:iterator value="indexList" begin="25" end="49">
                                                                    <tr>
                                                                        <td><s:property value="companyName"/></td>
                                                                        <td><font color="<s:property value="prevChange"/>"><s:property value="LTP"/></font></td>
                                                                        <td><s:property value="change"/></td>
                                                                        <td><s:property value="volume"/></td>
                                                                        <td><s:property value="buyPrice"/></td>
                                                                        <td><s:property value="sellPrice"/></td>
                                                                        <td><s:property value="buyQty"/></td>
                                                                        <td><s:property value="sellQty"/></td>
                                                                        <td>
                                                                            <a href="<s:url action="getIndexDetails"><s:param name="companyId"><s:property value="companyId"/></s:param></s:url>"> <i class="fa fa-bar-chart" style="font-size:10px;color:red"></i></a>

                                                                        </td>
                                                                    </tr>
                                                                </s:iterator>



                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>



                            </div>
                        </div>
                    </div>
                </div>

            </div>
           

        <!--   Core JS Files   -->
        <script src="assets/js/core/jquery.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <!--<script src="assets/js/core/bootstrap.min.js"></script>-->
        <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!--  Google Maps Plugin    -->
        <!-- Place this tag in your head or just before your close body tag. -->

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
        <!-- Chart JS -->
        <script src="assets/js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="assets/js/black-dashboard.min.js?v=1.0.0"></script>
        <!-- Black Dashboard DEMO methods, don't include it in your project! -->


    </body>


   

</html>