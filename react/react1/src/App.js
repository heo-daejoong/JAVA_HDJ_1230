import MapSample from "./01_MapSample";
import PropsSample from "./02_PropsSample";
import StateSample from "./03_StateSample";
import StateSample2 from "./04_StateSample2";
import StateSample3 from "./05_StateSample3";
import StateSample4 from "./06_StateSample4";
import ReadOnly from "./07_Readonly";
import Convert from "./08_Convert";
import Convert2 from "./09_Convert2";
import Convert3 from "./10_Convert3";


function App() {
  return (
    <div>
      <PropsSample/>
      <hr/>
      <StateSample/>
      <hr/>
      <StateSample2/>
      <hr/>
      <StateSample3/>
      <hr/>
      <MapSample/>
      <hr/>
      <StateSample4/>
      <hr/>
      <ReadOnly/>
      <hr/>
      <Convert/>
      <hr/>
      <Convert2/>
      <hr/>
      <Convert3/>
    </div>
  );
}

export default App;
