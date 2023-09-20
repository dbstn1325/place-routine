import placeRoutineApi from ".";

const loginApi = {
  endPoint: {
    googleEntry: "/api/auth/google/oauth-uri",
    googleToken: "/api/auth/google/token",
    validate: "/api/auth/validate/token",
    again: "/api/auth/token/access",
  },
  headers: {
    "Content-Type": "application/json",
    Accept: "application/json",
  },

  getUrl: async () => {
    const { data } = await placeRoutineApi.get(
      `${loginApi.endPoint.googleEntry}?redirectUri=${window.location.href}oauth`
    );

    return data.oauthUri;
  },

  auth: async (code) => {
    const { data } = await placeRoutineApi.post(loginApi.endPoint.googleToken, {
      code,
      redirectUri: window.location.href.split("?")[0],
    });

    return data;
  },

  relogin: async (refreshToken) => {
    const { data } = await placeRoutineApi.post(loginApi.endPoint.again, {
      refreshToken,
    });

    return data.accessToken;
  },

  validate: async (accessToken) => {
    const response = await placeRoutineApi.get(loginApi.endPoint.validate, {
      headers: { ...loginApi.headers, Authorization: `Bearer ${accessToken}` },
    });

    return response;
  },
};

export default loginApi;
