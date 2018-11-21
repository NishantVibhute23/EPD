<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

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
        
        
    </head>

    <body class="">
        <div class="wrapper">
            <div class="sidebar">
                <!--
                  Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red"
                -->
                <jsp:include page="sidebar.jsp"/>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <jsp:include page="navigationbar.jsp"/>
                <!-- End Navbar -->
                <div class="content">
                    <div class="row">
                        <div class="col-12">
                            <div class="card card-chart">
                                <div class="card-header ">
                                    <div class="row">
                                        <div class="col-sm-6 text-left">
                                            <h2 class="card-title">Top Gainers & Losers</h2>
                                        </div>
                                    </div>
                                    <div class="row">
        <div class='col-sm-6'>
            <input type='text' class="form-control" id='datetimepicker4' />
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker4').datetimepicker();
            });
        </script>
    </div>


                                </div>
                                <div class="card-body">
<div class="row">
          <div class="col-lg-6 col-md-12">
            <div class="card ">
              <div class="card-header">
                <h4 class="card-title"> Top Gainers</h4>
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
                          Open
                        </th>
                        <th>
                          High
                        </th>
                        <th>
                          Low
                        </th>
                        <th>
                          Last Price
                        </th>
                        <th>
                          Change
                        </th>
                        <th>
                          % chg.
                        </th>
                        
                      </tr>
                    </thead>
                    <tbody>
                        
                        <s:iterator value="gainerList">
                              <tr>
                              <td><s:property value="indexName"/></td>
                              <td><s:property value="open"/></td>
                              <td><s:property value="high"/></td>
                              <td><s:property value="low"/></td>
                              <td><s:property value="lastPrice"/></td>
                              <td><s:property value="change"/></td>
                               <td><s:property value="precChange"/></td>
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
                <h4 class="card-title">  Top Losers</h4>
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
                          Open
                        </th>
                        <th>
                          High
                        </th>
                        <th>
                          Low
                        </th>
                        <th>
                          Last Price
                        </th>
                        <th>
                          Change
                        </th>
                        <th>
                          % chg.
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                       <s:iterator value="losersList">
                              <tr>
                              <td><s:property value="indexName"/></td>
                              <td><s:property value="open"/></td>
                              <td><s:property value="high"/></td>
                              <td><s:property value="low"/></td>
                              <td><s:property value="lastPrice"/></td>
                              <td><s:property value="change"/></td>
                               <td><s:property value="precChange"/></td>
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
        </div>

        <!--   Core JS Files   -->
        <script src="assets/js/core/jquery.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <script src="assets/js/core/bootstrap.min.js"></script>
        <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!--  Google Maps Plugin    -->
        <!-- Place this tag in your head or just before your close body tag. -->
        <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
        <!-- Chart JS -->
        <script src="assets/js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="assets/js/black-dashboard.min.js?v=1.0.0"></script>
        <!-- Black Dashboard DEMO methods, don't include it in your project! -->


    </body>

</html>