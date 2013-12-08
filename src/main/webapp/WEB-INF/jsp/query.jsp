<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Weather Front</title>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <style type="text/css">
            body {
                font-family: arial; 
                font-size: 0.8em;
            }
            fieldset {
                width: 600px;
            }
            fieldset ul, fieldset li{
                border:0; margin:0; padding:10px 10px 10px 10px; list-style:none;
            }
            fieldset li{
                clear:both;
                padding-bottom:10px;
            }
            fieldset input{
                float:left;
            }
            fieldset label{
                width:140px;
                float:left;
            }
            #weather_showtable {
                width:620px;
            }
            #weather_showtable tr td {
                padding:10px 10px 10px 10px;
                text-align: center;
            }
            #reset {
                color: red;
            }
        </style>

    </head>
    <body>
        <form name="weather_form" action="query" method="post">
            <fieldset>
                <legend><b>Query</b></legend>
                <ul>
                    <li> 
                        <label for="name">ZIP:</label>
                        <input type="text" name="zip" id="zip" size="30" maxlength="5" required />
                        <button type="submit" id="send" name="send">Send</button> 
                    </li>
                </ul>
            </fieldset>
            <br>
            <table id="weather_showtable" cellpadding=6 rules=groups  frame=box>
                <thead>
                    <tr> 
                        <th>City</th> 
                        <th>State</th> 
                        <th>Temperature (F)</th> 
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </form>
        <script type="text/javascript">
            $('form').submit(function(event) {
              event.preventDefault();
              var zip = $('#zip').val();
              $.ajax({
                  type: "POST",
                  url: $('#weather_form').attr('action'),
                  dataType: "json",
                  data: {zip: zip},
                  success: function(data) {
                      populateTable(data);
                  },
                  error: function(e) {
                      alert(e);
                  }
              });
            });
            
            function populateTable(temperature) {
                var row = "<tr> \
                            <td>"+temperature.city+"</td> \
                            <td>"+temperature.state+"</td> \
                            <td>"+temperature.temperature+"</td> \
                           </tr>";                
                $("tbody").html(row);
            }
        </script>
    </body>
</html>
