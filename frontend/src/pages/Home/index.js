import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import { useQuery } from "react-query";
import { useHistory } from "react-router-dom";
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
        {/* halo */}
      </MapViewArea>
    </>
  );
};
