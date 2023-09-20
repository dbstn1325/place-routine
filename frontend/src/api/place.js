import placeRoutineApi from ".";

function createPlaceRequestBody() {
  return {
    name: "Sample Place Name", // Replace with actual value
    categoryType: "코딩", // Replace with actual value
    openDateTime: new Date().toISOString().slice(0, 16), // Adjust according to your needs
    closeDateTime: new Date().toISOString().slice(0, 16), // Adjust according to your needs
    location: {
      latitude: 35.15316467444626,
      longitude: 128.0997135227073,
    },
    memo: "Sample memo", // Replace with actual value
  };
}

const placeApi = {
  endpoint: {
    get: "/api/places",
    post: function () {
      return `/api/places`;
    },
    // delete: function (scheduleId) {
    //   return `/api/schedules/${scheduleId}`;
    // },
  },

  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },
  // get: async (latitude, longitude) => {
  //   const response = await dallogApi.get(
  //     `${scheduleApi.endpoint.get}?latitude=${latitude}&longitude=${longitude}`
  //   );
  //   //   {
  //   //     headers: {
  //   //       ...scheduleApi.headers,
  //   //       Authorization: `Bearer ${accessToken}`,
  //   //     },
  //   //   }

  //   return response;
  // },

  get: async function (latitude, longitude) {
    const response = await placeRoutineApi.get(
      `${placeApi.endpoint.get}?latitude=${latitude}&longitude=${longitude}`
    );

    console.log(response);

    return response;
  },

  post: async (body) => {
    const response = await placeRoutineApi.post(
      placeApi.endpoint.post(),
      (body = createPlaceRequestBody())
      // {
      //   headers: {
      //     ...scheduleApi.headers,
      //     Authorization: `Bearer ${accessToken}`,
      //   },
      // }
    );
    console.log(response);

    return response;
  },

  // delete: async (accessToken, scheduleId) => {
  //   const response = await dallogApi.delete(
  //     scheduleApi.endpoint.delete(scheduleId),
  //     {
  //       headers: { Authorization: `Bearer ${accessToken}` },
  //     }
  //   );

  //   return response;
  // },
};

export default placeApi;
