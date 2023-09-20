import React, { useState, useEffect } from "react";
import { INIT_POINT } from "../../constants/domain";
import { useMapView } from "../../hooks/useMapView";
import { MapView, MapViewArea } from "./style";

export const HomePage = () => {
  const { mapViewRef, showMapView } = useMapView();

  useEffect(() => {
    showMapView(INIT_POINT);
  }, []);

  return (
    <>
      <MapViewArea>
        <MapView ref={mapViewRef} />
      </MapViewArea>
    </>
  );
};
