import { LogoAndDescription } from "./App/Logo";
import { FileUpload } from "./FileUpload";

function App() {
  return (
    <div className="flex flex-col justify-center gap-12 mt-10 md:mt-20 md:gap-20">
      <LogoAndDescription />
      <div className="container mx-auto px-4 max-w-4xl">
        <FileUpload />
      </div>
    </div>
  );
}

export default App;
