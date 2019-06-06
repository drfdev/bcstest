<%@ page contentType="text/html; charset=UTF-8" %>
<% response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Вызов сервиса</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript" language="JavaScript"></script>
<script>
var SERVICE_URL = 'http://localhost:8080/bcstest';
function callService() {
//    var inputJson = $('#inputJson');
//    var resultJson = $('#resultJson');

    $.ajax({
        url: SERVICE_URL,
        dataType: 'json',
        data: {
            json: $('#inputJson').val()
        },
        complete: function (resultObject) {
            var resultText = JSON.stringify(resultObject.responseText);
            $('#resultJson').val(resultText);
        }
    });
    inputJson.val();
}
</script>
</head>
<body>
    <table>
        <tr>
            <td width="40%">Исходящий JSON:</td>
            <td width="20%"></td>
            <td width="40%">Результат:</td>
        </tr>
        <tr>
            <td>
                <textarea rows="30" cols="80" id="inputJson">{
    "stocks":[
      {
         "symbol":"AAPL",
         "volume":50
      },
      {
         "symbol":"HOG",
         "volume":10
      },
      {
         "symbol":"MDSO",
         "volume":1
      },
      {
         "symbol":"IDRA",
         "volume":1
      },
      {
         "symbol":"MRSN",
         "volume":1
      }
    ]
}</textarea>
            </td>
            <td valign="center" align="middle">
                <button onclick="javascript:callService();">Отправить</button>
            </td>
            <td>
                <textarea rows="30" cols="80" id="resultJson"></textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</body>
</html>