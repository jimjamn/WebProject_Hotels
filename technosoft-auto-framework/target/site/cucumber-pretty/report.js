$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotelsHome.feature");
formatter.feature({
  "line": 2,
  "name": "Hotels Web Project Home",
  "description": "",
  "id": "hotels-web-project-home",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select \u003cnumber of rooms\u003e from the rooms drop down list",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is \u003cexpected\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;",
  "rows": [
    {
      "cells": [
        "number of rooms",
        "expected"
      ],
      "line": 13,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;1"
    },
    {
      "cells": [
        "1",
        "1"
      ],
      "line": 14,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;2"
    },
    {
      "cells": [
        "2",
        "2"
      ],
      "line": 15,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;3"
    },
    {
      "cells": [
        "3",
        "3"
      ],
      "line": 16,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;4"
    },
    {
      "cells": [
        "4",
        "4"
      ],
      "line": 17,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;5"
    },
    {
      "cells": [
        "5",
        "5"
      ],
      "line": 18,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;6"
    },
    {
      "cells": [
        "6",
        "6"
      ],
      "line": 19,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;7"
    },
    {
      "cells": [
        "7",
        "7"
      ],
      "line": 20,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;8"
    },
    {
      "cells": [
        "8",
        "8"
      ],
      "line": 21,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;9"
    },
    {
      "cells": [
        "9+",
        "0"
      ],
      "line": 22,
      "id": "hotels-web-project-home;verify-room-count-drop-down;;10"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 14100302357,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 604825509,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 1 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 1",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 365173665,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 22050697,
  "status": "passed"
});
formatter.after({
  "duration": 394964009,
  "status": "passed"
});
formatter.before({
  "duration": 5231156392,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 50735422,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 2 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 2",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 380365433,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 21286418,
  "status": "passed"
});
formatter.after({
  "duration": 433810704,
  "status": "passed"
});
formatter.before({
  "duration": 4881358060,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 47900747,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 3 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 3",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 312450149,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 19195900,
  "status": "passed"
});
formatter.after({
  "duration": 425337356,
  "status": "passed"
});
formatter.before({
  "duration": 5192175037,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 154064185,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 4 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 4",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 504481020,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 18372365,
  "status": "passed"
});
formatter.after({
  "duration": 624742272,
  "status": "passed"
});
formatter.before({
  "duration": 76538569362,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 65431613,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 5 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 5",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 352381291,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 21481347,
  "status": "passed"
});
formatter.after({
  "duration": 981445392,
  "status": "passed"
});
formatter.before({
  "duration": 11814736504,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 382121186,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;7",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 6 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 6",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 489879339,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 23035157,
  "status": "passed"
});
formatter.after({
  "duration": 954779632,
  "status": "passed"
});
formatter.before({
  "duration": 6751782338,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 49366818,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;8",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 7 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 7",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 298882166,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 19177327,
  "status": "passed"
});
formatter.after({
  "duration": 493714599,
  "status": "passed"
});
formatter.before({
  "duration": 5685667336,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 143781389,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;9",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 8 from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 8",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 20
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 353953844,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 270045796,
  "status": "passed"
});
formatter.after({
  "duration": 520268862,
  "status": "passed"
});
formatter.before({
  "duration": 5441229599,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on the Hotels home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HotelsHomeSD.iAmOnTheHotelsHomePage()"
});
formatter.result({
  "duration": 49036543,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Verify room count drop down",
  "description": "",
  "id": "hotels-web-project-home;verify-room-count-drop-down;;10",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@webprojecthotels"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 7,
      "name": "@webproject_hotel_home_1"
    },
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 7,
      "name": "@FA2-311"
    },
    {
      "line": 1,
      "name": "@webprojecthotelshome"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I select 9+ from the rooms drop down list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I verify the correct number of occupancy panels displayed is 0",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "9+",
      "offset": 9
    },
    {
      "val": "rooms",
      "offset": 21
    }
  ],
  "location": "HotelsHomeSD.selectItemFromRoomsDDLByText(String,String)"
});
formatter.result({
  "duration": 584057226,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 61
    }
  ],
  "location": "HotelsHomeSD.verifyNumOfOccupancyPanelMatchesNumRoomSelected(String)"
});
formatter.result({
  "duration": 10068874360,
  "status": "passed"
});
formatter.after({
  "duration": 585320558,
  "status": "passed"
});
});