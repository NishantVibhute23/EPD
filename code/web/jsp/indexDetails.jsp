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
                            <s:hidden id="data" value="%{dataMA}" name="dataMA"/>
                            <div id="line-chart"></div>
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

<!--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>-->
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

    <script>
        $(document).ready(function() {
            
         
                       
            

  
  
  var line =  Morris.Line({
    element: 'line-chart',
    xkey: 'companyName',
    ykeys: ['LTP', 'LTP'],
    labels: ['Series A', 'Series B'],
    lineColors: ['#1e88e5','#ff3321'],
    lineWidth: '3px',
    resize: true,
    redraw: true
  });

  lineChart();

  $(window).resize(function() {
    window.lineChart.redraw();
  });
  
  
  function lineChart() {
line.setData($("#data").val());
}
});
        

        </script>
        
   

</html>