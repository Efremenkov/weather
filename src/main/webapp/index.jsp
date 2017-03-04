<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Weather</title>
  </head>
  <body>
    <form name="Forml" action="http://localhost:8080/weather-1.0-SNAPSHOT/api/v1/weather">
      Enter the coordinates
      <table>
        <tr>
          <td><B>Longitude:</B></td>
          <td><input type=textbox name="lon" size="25" value=""></td>
        </tr>
        <tr>
          <td><B>Latitude:</B></td>
          <td><input type=textbox name="lat" size="25" value=""></td>
        </tr>
      </table>
      <input type="submit" value="Get Weather">
    </form>
  </body>
</html>
