import './Header.css'

const Header = () => {
    return (
        <div className="Header">
            <h3>오늘은 📆</h3>
            {/* => 윈도우 이모지 : 윈도우+ .  누르면 표시됨 */}
            <h1>{new Date().toDateString()}</h1>
        </div>
    );
};

export default Header
