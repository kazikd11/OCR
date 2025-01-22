import numpy as np
from PIL import Image
from skimage.metrics import structural_similarity as ssim
from scipy import ndimage
import cv2

class OcrAlgorithm:
    def __init__(self):
        self.patterns = {
            'A': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,1],
                [1,0,0,0,1],
                [1,0,0,0,1]
            ],
            'B': [
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,0]
            ],
            'C': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [1,0,0,0,0],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            'D': [
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,1,1,1,0]
            ],
            'E': [
                [1,1,1,1,1],
                [1,0,0,0,0],
                [1,1,1,1,0],
                [1,0,0,0,0],
                [1,1,1,1,1]
            ],
            'F': [
                [1,1,1,1,1],
                [1,0,0,0,0],
                [1,1,1,1,0],
                [1,0,0,0,0],
                [1,0,0,0,0]
            ],
            'G': [
                [0,1,1,1,0],
                [1,0,0,0,0],
                [1,0,1,1,1],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            'H': [
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,1,1,1,1],
                [1,0,0,0,1],
                [1,0,0,0,1]
            ],
            'I': [
                [1,1,1,1,1],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [1,1,1,1,1]
            ],
            'J': [
                [0,0,0,0,1],
                [0,0,0,0,1],
                [0,0,0,0,1],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            'K': [
                [1,0,0,0,1],
                [1,0,0,1,0],
                [1,1,1,0,0],
                [1,0,0,1,0],
                [1,0,0,0,1]
            ],
            'L': [
                [1,0,0,0,0],
                [1,0,0,0,0],
                [1,0,0,0,0],
                [1,0,0,0,0],
                [1,1,1,1,1]
            ],
            'M': [
                [1,0,0,0,1],
                [1,1,0,1,1],
                [1,0,1,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1]
            ],
            'N': [
                [1,0,0,0,1],
                [1,1,0,0,1],
                [1,0,1,0,1],
                [1,0,0,1,1],
                [1,0,0,0,1]
            ],
            'O': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            'P': [
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,0],
                [1,0,0,0,0],
                [1,0,0,0,0]
            ],
            'Q': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [1,0,1,0,1],
                [1,0,0,1,0],
                [0,1,1,0,1]
            ],
            'R': [
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,0],
                [1,0,0,1,0],
                [1,0,0,0,1]
            ],
            'S': [
                [0,1,1,1,0],
                [1,0,0,0,0],
                [0,1,1,1,0],
                [0,0,0,0,1],
                [0,1,1,1,0]
            ],
            'T': [
                [1,1,1,1,1],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0]
            ],
            'U': [
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            'V': [
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [0,1,0,1,0],
                [0,0,1,0,0]
            ],
            'W': [
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,1,0,1],
                [1,1,0,1,1],
                [1,0,0,0,1]
            ],
            'X': [
                [1,0,0,0,1],
                [0,1,0,1,0],
                [0,0,1,0,0],
                [0,1,0,1,0],
                [1,0,0,0,1]
            ],
            'Y': [
                [1,0,0,0,1],
                [0,1,0,1,0],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0]
            ],
            'Z': [
                [1,1,1,1,1],
                [0,0,0,1,0],
                [0,0,1,0,0],
                [0,1,0,0,0],
                [1,1,1,1,1]
            ],
            '0': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            '1': [
                [0,0,1,0,0],
                [0,1,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,1,1,1,0]
            ],
            '2': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [0,0,1,1,0],
                [0,1,0,0,0],
                [1,1,1,1,1]
            ],
            '3': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [0,0,1,1,0],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            '4': [
                [0,0,1,1,0],
                [0,1,0,1,0],
                [1,0,0,1,0],
                [1,1,1,1,1],
                [0,0,0,1,0]
            ],
            '5': [
                [1,1,1,1,1],
                [1,0,0,0,0],
                [1,1,1,1,0],
                [0,0,0,0,1],
                [1,1,1,1,0]
            ],
            '6': [
                [0,1,1,1,0],
                [1,0,0,0,0],
                [1,1,1,1,0],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            '7': [
                [1,1,1,1,1],
                [0,0,0,1,0],
                [0,0,1,0,0],
                [0,1,0,0,0],
                [0,1,0,0,0]
            ],
            '8': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [0,1,1,1,0],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            '9': [
                [0,1,1,1,0],
                [1,0,0,0,1],
                [0,1,1,1,1],
                [0,0,0,0,1],
                [0,1,1,1,0]
            ]
        }
        
    def preprocess_image(self, image_path):
        # Load and convert image to grayscale
        image = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
        
        # Basic thresholding instead of adaptive
        _, binary_image = cv2.threshold(image, 127, 255, cv2.THRESH_BINARY)
        
        # Invert if text is black on white
        if np.mean(binary_image) > 127:
            binary_image = cv2.bitwise_not(binary_image)
            
        return binary_image

    def extract_text(self, image_path):
        binary_image = self.preprocess_image(image_path)
        labeled_array, num_features = ndimage.label(binary_image)

        if num_features == 0:
            print("No characters found in the image.")
            return ""

        regions = []
        for i in range(1, num_features + 1):
            region = (labeled_array == i)
            if np.sum(region) > 20:
                y, x = np.where(region)
                regions.append({
                    'x': min(x),
                    'y': min(y),
                    'width': max(x) - min(x),
                    'height': max(y) - min(y),
                    'region': region
                })

        print(f"\nFound {len(regions)} potential characters.")
        regions.sort(key=lambda r: r['x'])

        recognized_text = []
        prev_x_end = 0
        avg_width = np.mean([r['width'] for r in regions])
        
        for region in regions:
            # Check for space
            if prev_x_end > 0 and (region['x'] - prev_x_end) > 1.5 * avg_width:
                recognized_text.append(' ')
            
            char_image = binary_image[
                region['y']:region['y'] + region['height'] + 1,
                region['x']:region['x'] + region['width'] + 1
            ]
            
            # Ensure minimum size and padding
            char_image = cv2.resize(char_image, (7, 7))
            char_image = cv2.resize(char_image, (5, 5))
            
            # Normalize to binary values
            char_image = (char_image > 127).astype(np.int32)

            char = self.recognize_character(char_image)
            recognized_text.append(char)
            prev_x_end = region['x'] + region['width']

        result = ''.join(recognized_text)
        print(f"\nFinal recognized text: {result}")
        return result

    def calculate_match_score(self, window, pattern):
        pattern = np.array(pattern)
        return np.sum(np.abs(window - pattern)) / 25  # Fixed size of 5x5

    def recognize_character(self, char_image):
        best_match = ' '
        best_score = float('inf')

        for char, pattern in self.patterns.items():
            score = self.calculate_match_score(char_image, pattern)
            if score < best_score:
                best_score = score
                best_match = char

        # More lenient threshold
        return best_match if best_score < 0.5 else ' '


def test_ocr():
    """Test function to verify OCR functionality."""
    ocr = OcrAlgorithm()
    try:
        text = ocr.extract_text("test_image.png")  # Replace with your test image
        print("Recognized text:")
        print(text)
    except Exception as e:
        print(f"Error during OCR: {str(e)}")

if __name__ == "__main__":
    test_ocr()