<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Weather</title>
    <script src="lib/jquery-3.1.1.min.js"></script>
    <script src="lib/inputmask.js"></script>
  </head>
  <body>
      Configure cache:
      <table>
        <tr>
          <td>Heap size:</td>
          <td><input type=textbox id="heapSize" name="heapSize" size="5" value="">&nbsp<label>entries</label></td>
        </tr>
        <tr>
          <td>Offheap size:</td>
          <td><input type=textbox id="offheapSize" name="offheapSize" size="5" value="">&nbsp<label>MB</label></td>
        </tr>
        <tr>
          <td>Disk size:</td>
          <td><input type=textbox id="diskMemSize" name="diskMemSize" size="5" value="">&nbsp<label>MB</label></td>
        </tr>
        <tr>
          <td>Duration:</td>
          <td><input type=textbox id="duration" name="duration" size="5" value="">&nbsp<label>minutes</label></td>
        </tr>
        <tr>
          <td>Use disk cache:</td>
          <td><input type="checkbox" class ="js-use-disk-cache" id="diskCache" name="diskCache" value=""></td>
        </tr>
      </table>
      <a href="#" class ="js-cache">Configure</a>
      <br/><br/>
      Enter the coordinates:
      <table>
        <tr>
          <td><B>Longitude:</B></td>
          <td><input type=textbox id="lon" name="lon" size="25" value=""></td>
        </tr>
        <tr>
          <td><B>Latitude:</B></td>
          <td><input type=textbox id="lat" name="lat" size="25" value=""></td>
        </tr>
      </table>
      <a href="#" class ="js-weather">Get weather</a>
      <br/><br/>
      <textarea id="weatherInfo" cols="80" rows="4"></textarea>

    <script>
        $(document).ready(function () {
            var im = new Inputmask("9[9]");
            im.mask($("input#heapSize"));
            im.mask($("input#diskMemSize"));
            im.mask($("input#offheapSize"));
            im = new Inputmask("9[99]");
            im.mask($("input#duration"))

            $(".js-weather").click(function(e)
            {
                e.preventDefault();
                var lon = $("input#lon").val();
                var lat = $("input#lat").val();
                if(!lon.length || !lat.length) {
                    alert("Enter coordinates")
                    return
                }
                $.ajax({
                    method: "GET",
                    url: "/api/v1/weather",
                    data: {
                        lon: lon,
                        lat: lat
                    }
                })
                    .done(function (response) {
                        console.log("Get response", response)
                        $("textarea#weatherInfo").val(
                            "In " + response.location + ", " + response.country +
                            "\nmax temperature:  " + response.maxT +
                            "\nmin temperature:  " + response.minT
                        );

                        return
                    })
                    .fail(function (error) {
                        console.log("Response error", error)
                        alert(error.responseJSON.message);
                        }
                    );

                return false;
            });

            $(".js-cache").click(function(e)
            {
                e.preventDefault();
                var heapSize = $("input#heapSize").val();
                var offheapSize = $("input#offheapSize").val();
                var diskMemSize = $("input#diskMemSize").val();
                var duration = $("input#duration").val();
                if(!heapSize.length || !offheapSize.length || !diskMemSize.length || !duration.length) {
                    alert("Enter all configurations parameters")
                    return
                }
                if(offheapSize >= diskMemSize) {
                    alert("Pool offheap must be smaller than pool disk")
                    return
                }
                var data="<CacheConfigurationRq>"+
                        "<heapSize>"+heapSize+"</heapSize>"+
                        "<offheapSize>"+offheapSize+"</offheapSize>"+
                        "<diskMemSize>"+diskMemSize+"</diskMemSize>"+
                        "<duration>"+duration+"</duration>"+
                        "</CacheConfigurationRq>"
                $.ajax({
                    headers: {
                        'Content-Type': 'application/xml'
                    },
                    method: "POST",
                    url: "/api/v1/cache/configure",
                    data: data,
                    contentType: "text/xml",
                    dataType: "text"
                })
                    .done(function (response) {
                        console.log("Get response", response)
                        return
                    })
                    .fail(function (error) {
                        console.log("Response error", error)
                        alert((jQuery.parseJSON(error.responseText)).message);
                        }
                    );

                return false;
            })

            $(".js-use-disk-cache").click(function(e)
            {
                $.ajax({
                    method: "GET",
                    url: "/api/v1/cache/source/change",
                })
                    .done(function (response) {
                        console.log("Get response", response)
                        if($("#diskCache").is(":checked")) {
                            $("#diskCache").prop('checked', false)
                        } else {
                            $("#diskCache").prop('checked', true)
                        };
                        return
                    })
                    .fail(function (error) {
                        console.log("Response error", error)
                        }
                    );

                return false;
            });
        });
    </script>
  </body>
</html>
