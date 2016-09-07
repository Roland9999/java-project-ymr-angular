

document.addEventListener("deviceready", function() {
    navigator.geolocation.getCurrentPosition(searchRestaurantsNearBy);

    function searchRestaurantsNearBy(position) {
        $.get("http://localhost:8080/api/restaurants/nearby",
            {
                latitude: position.coords.latitude,
                longitude: position.coords.longitude
            },
            function(data) {
                console.log(data);

                var loadingBarElement = $("#p2");

                $(".mdl-card").remove();
                loadingBarElement.show();
                $.each(data, function(r) {
                    console.log("Displaying restaurant: " + data[r].name);

                    if (data[r].photo !== null && data[r].photo !== undefined && data[r].photo !== "") {
                        console.log("with photo");
                        $(".demo-blog__posts").append(
                            "<div class=\"mdl-card coffee-pic mdl-cell mdl-cell--12-col\">" +
                            "   <div class=\"mdl-card__media mdl-color-text--grey-50\" style=\"background-image: url('data:"+ data[r].photoType + ";base64,"+ data[r].photo+"');\">" +
                            "       <h3><a href=\"entry.html\">"+ data[r].name + " </a></h3>" +
                            "   </div>" +
                            "   <div class=\"mdl-card__supporting-text meta mdl-color-text--grey-600\">" +
                            "       <div class=\"minilogo\" style=\"background-image: url('"+ data[r].icon +"')\">" +
                            "       <img src=\"\" />   " +
                            "       </div>" +
                            "       <div>" +
                            "           <strong>" + data[r].address + "</strong>" +
                            "           <span>300m</span>" +
                            "       </div>" +
                            "   </div>" +
                            "</div>"
                        )
                    } else {
                        console.log("without photo");
                        $(".demo-blog__posts").append(
                            "<div class=\"mdl-card coffee-pic mdl-cell mdl-cell--12-col\">" +
                            "   <div class=\"mdl-card__media mdl-color-text--grey-50\">" +
                            "       <h3><a href=\"entry.html\">"+ data[r].name + " </a></h3>" +
                            "   </div>" +
                            "   <div class=\"mdl-card__supporting-text meta mdl-color-text--grey-600\">" +
                            "       <div class=\"minilogo\">" +
                            "       <img src=\"\" />   " +
                            "       </div>" +
                            "       <div>" +
                            "           <strong>" + data[r].address + "</strong>" +
                            "           <span>300m</span>" +
                            "       </div>" +
                            "   </div>" +
                            "</div>"
                        )
                    }
                });

                loadingBarElement.hide();
            }
        );
    }
}, false);