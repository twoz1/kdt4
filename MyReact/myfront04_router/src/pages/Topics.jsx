import { NavLink,Route,Routes } from "react-router-dom";
const Topics=()=>{

    return(
        <div>
            나는
            <ul>
                <li>
                    <NavLink to="/topics/1">Html </NavLink>
                </li>
                <li>
                    <NavLink to="/topics/2">JavaScript</NavLink>
                </li>
                <li>
                    <NavLink to="/topics/3">React</NavLink>
                </li>
            </ul>

            <Routes>
                <Route path='1' element={'Html은 재밌다~~'} />
                <Route path='2' element={'JavaScript는 재밌다~~'} />
                <Route path='3' element={'React는 재밌다~~'} />
            </Routes>
        </div>
    ); //return
}  //Topics
export default Topics;