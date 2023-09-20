import { useState, useRef } from "react";

export const useMapView = () => {
  let mapObj = useRef(null);
  const mapViewRef = useRef(null);

  const showMapView = (midpoint) => {
    const { x, y, level = 3 } = midpoint;
    const options = { center: new kakao.maps.LatLng(y, x), level };

    mapObj = new kakao.maps.Map(mapViewRef?.current, options);
  };

  return { mapViewRef, showMapView };
};
