﻿CKEDITOR.dialog.add("leaflet",function(){return{title:"Create/Edit Leaflet Map",minWidth:320,minHeight:125,contents:[{id:"location_tab",label:"Location",elements:[{id:"map_geocode",className:"geocode",type:"text",label:"Auto-Search of Coordinates.",style:"margin-top: -7px;",setup:function(){this.setValue("")},onShow:function(){var a=jQuery(".geocode input")[0];new google.maps.places.Autocomplete(a);a=jQuery('<style type="text/css" />');a.html(".pac-container { z-index: 100000 !important;} input.minimap { margin-top: 18px !important; }");
jQuery("head").append(a)}},{type:"html",id:"map_label",className:"label",style:"margin-bottom: -10px;",html:"<p>Manual Input of Coordinates:</p>"},{type:"hbox",widths:["50%","50%"],children:[{id:"map_latitude",className:"latitude",type:"text",label:"Latitude",setup:function(a){""!=a.element.data("lat")&&this.setValue(a.element.data("lat"))}},{id:"map_longitude",className:"longitude",type:"text",label:"Longitude",setup:function(a){""!=a.element.data("lon")&&this.setValue(a.element.data("lon"))}}]},
{id:"popup_text",className:"popup-text",type:"text",label:"Pop-up Text (Optional)",style:"margin-bottom: 8px;",setup:function(a){""!=a.element.data("popup-text")?this.setValue(a.element.data("popup-text")):jQuery(".popup-text input").attr("placeholder","Enter the marker's text.")}}]},{id:"options_tab",label:"Options",elements:[{type:"hbox",style:"margin-top: -7px;",widths:["38%","38%","24%"],children:[{id:"width",className:"map_width",type:"text",label:"Map Width",setup:function(a){jQuery(".map_width input").attr("placeholder",
"400");""!=a.element.data("width")&&this.setValue(a.element.data("width"))}},{id:"height",className:"map_height",type:"text",label:"Map Height",setup:function(a){jQuery(".map_height input").attr("placeholder","400");""!=a.element.data("height")&&this.setValue(a.element.data("height"))}},{id:"map_zoom",className:"zoom",type:"select",label:"Zoom Level",width:"70px",items:[["1"],["2"],["3"],["4"],["5"],["6"],["7"],["8"],["9"],["10"],["11"],["12"],["13"],["14"],["15"],["16"],["17"],["18"],["19"],["20"]],
setup:function(a){if(""!=a.element.data("zoom")){var b=a.element.data("zoom"),a=a.element.getChild(0).$.contentDocument.getElementById("map_container").getAttribute("data-zoom");a!=b&&(b=a);this.setValue(b)}else this.setValue("10")}}]},{type:"hbox",widths:["50%","50%"],children:[{type:"select",id:"map_tile",className:"tile",label:"Base Map Tile",items:[["MapQuestOpen.OSM"],["MapQuestOpen.Aerial"],["OpenStreetMap.Mapnik"],["OpenStreetMap.DE"],["OpenStreetMap.HOT"],["Esri.DeLorme"],["Esri.NatGeoWorldMap"],
["Esri.WorldPhysical"],["Esri.WorldTopoMap"],["Thunderforest.OpenCycleMap"],["Thunderforest.Landscape"],["Stamen.Watercolor"]],setup:function(a){""!=a.element.data("tile")?this.setValue(a.element.data("tile")):this.setValue("MapQuestOpen.OSM")},commit:function(a){a.element.setHtml("");var b=jQuery(".geocode input").val(),g,h;if(""!=b){var c="//maps.googleapis.com/maps/api/geocode/json?address="+b+"&sensor=false";jQuery.ajaxSetup({async:!1});jQuery.getJSON(c,function(a){"ZERO_RESULTS"!=a.status?(g=
a.results[0].geometry.location.lat,h=a.results[0].geometry.location.lng):alert("The Place could not be Geocoded properly. Kindly choose another one.")})}var c=jQuery(".latitude input").val(),f=jQuery(".longitude input").val(),d=a.element.data("lat"),i=a.element.data("lon");if(""!=c&&""!=f&&(c!=d&&f!=i||""==b))g=c,h=f;var b=jQuery(".map_width input").val()||"400",c=jQuery(".map_height input").val()||"400",d=jQuery("select.zoom").val(),i=jQuery(".popup-text input").val(),k=jQuery("select.tile").val(),
e=jQuery("select.alignment").val(),j=jQuery(".minimap input:checked").val();void 0==j&&(j="off");f=(new Date).getTime();a.element.setAttribute("id","leaflet_div-"+f);a.element.data("lat",g);a.element.data("lon",h);a.element.data("width",b);a.element.data("height",c);a.element.data("zoom",d);a.element.data("popup-text",i);a.element.data("tile",k);a.element.data("minimap",j);a.element.data("alignment",e);a.element.removeClass("align-left");a.element.removeClass("align-right");a.element.removeClass("align-center");
a.element.addClass("align-"+e);e=jQuery(".responsive input:checked").val();void 0==e?(e="off",a.element.removeClass("responsive-map")):a.element.addClass("responsive-map");a.element.data("responsive",e);mapParserPathFull=mapParserPath+"?lat="+g+"&lon="+h+"&width="+b+"&height="+c+"&zoom="+d+"&text="+i+"&tile="+k+"&minimap="+j+"&responsive="+e;d=new CKEDITOR.dom.element("iframe");d.setAttributes({scrolling:"no",id:"leaflet_iframe-"+f,"class":"leaflet_iframe",width:b+"px",height:c+"px",frameborder:0,
allowTransparency:!0,src:mapParserPathFull,"data-cke-saved-src":mapParserPathFull});"on"==e&&d.setAttribute("class","leaflet_iframe responsive-map-iframe");a.element.append(d)}},{type:"checkbox",id:"map_mini",className:"minimap",label:"Include MiniMap",setup:function(a){""!=a.element.data("minimap")&&"on"!=a.element.data("minimap")?this.setValue(""):this.setValue("true")}}]},{type:"hbox",widths:["20%","80%"],children:[{id:"map_alignment",className:"alignment",type:"select",label:"Alignment",items:[["Left",
"left"],["Right","right"],["Center","center"]],style:"margin-bottom: 4px;",setup:function(a){""!=a.element.data("alignment")?this.setValue(a.element.data("alignment")):this.setValue("left")}},{type:"checkbox",id:"map_responsive",className:"responsive",label:"Responsive Map (100% Width)",style:"margin-top: 18px;",setup:function(a){""!=a.element.data("responsive")?"on"==a.element.data("responsive")?this.setValue("true"):this.setValue(""):this.setValue("")}}]}]}]}});