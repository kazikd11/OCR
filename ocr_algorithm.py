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
                [0,1,1,1,1],
                [1,0,0,0,0],
                [1,0,0,0,0],
                [1,0,0,0,0],
                [0,1,1,1,1]
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
                [0,1,1,1,1],
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
                [0,0,0,1,1],
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
                [1,0,1,0,1],
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
            ],
            'a': [
                [0,0,0,0,0],
                [0,1,1,1,0],
                [0,0,0,0,1],
                [0,1,1,1,1],
                [0,1,1,1,1]
            ],
            'b': [
                [1,0,0,0,0],
                [1,0,0,0,0],
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,0]
            ],
            'c': [
                [0,0,0,0,0],
                [0,1,1,1,0],
                [1,0,0,0,0],
                [1,0,0,0,0],
                [0,1,1,1,0]
            ],
            'd': [
                [0,0,0,1,0],
                [0,0,0,1,0],
                [0,1,1,1,0],
                [1,0,0,1,0],
                [0,1,1,1,0]
            ],
            'e': [
                [0,0,0,0,0],
                [0,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,0],
                [0,1,1,1,0]
            ],
            'f': [
                [0,0,1,1,0],
                [0,1,0,0,0],
                [1,1,1,1,0],
                [0,1,0,0,0],
                [0,1,0,0,0]
            ],
            'g': [
                [0,1,1,1,1],
                [1,0,0,0,1],
                [0,1,1,1,1],
                [0,0,0,0,1],
                [0,1,1,1,0]
            ],
            'h': [
                [1,0,0,0,0],
                [1,0,0,0,0],
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,0,0,0,1]
            ],
            'i': [
                [0,0,1,0,0],
                [0,0,0,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0]
            ],
            'j': [
                [0,0,0,1,0],
                [0,0,0,0,0],
                [0,0,0,1,0],
                [1,0,0,1,0],
                [0,1,1,0,0]
            ],
            'k': [
                [1,0,0,0,0],
                [1,0,0,1,0],
                [1,0,1,0,0],
                [1,1,0,1,0],
                [1,0,0,1,0]
            ],
            'l': [
                [0,1,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,0,1,0,0],
                [0,1,1,1,0]
            ],
            'm': [
                [0,0,0,0,0],
                [1,1,0,1,0],
                [1,0,1,0,1],
                [1,0,1,0,1],
                [1,0,1,0,1]
            ],
            'n': [
                [0,0,0,0,0],
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,0,1]
            ],
            'o': [
                [0,0,0,0,0],
                [0,1,1,1,0],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [0,1,1,1,0]
            ],
            'p': [
                [1,1,1,1,0],
                [1,0,0,0,1],
                [1,1,1,1,0],
                [1,0,0,0,0],
                [1,0,0,0,0]
            ],
            'q': [
                [0,1,1,1,1],
                [1,0,0,0,1],
                [0,1,1,1,1],
                [0,0,0,0,1],
                [0,0,0,0,1]
            ],
            'r': [
                [0,0,0,0,0],
                [1,0,1,1,0],
                [1,1,0,0,1],
                [1,0,0,0,0],
                [1,0,0,0,0]
            ],
            's': [
                [0,0,0,0,0],
                [0,1,1,1,0],
                [0,1,1,0,0],
                [0,0,0,1,0],
                [1,1,1,0,0]
            ],
            't': [
                [0,1,0,0,0],
                [1,1,1,1,0],
                [0,1,0,0,0],
                [0,1,0,0,1],
                [0,0,1,1,0]
            ],
            'u': [
                [0,0,0,0,0],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [1,0,0,1,1],
                [0,1,1,0,1]
            ],
            'v': [
                [0,0,0,0,0],
                [1,0,0,0,1],
                [1,0,0,0,1],
                [0,1,0,1,0],
                [0,0,1,0,0]
            ],
            'w': [
                [0,0,0,0,0],
                [1,0,0,0,1],
                [1,0,1,0,1],
                [1,0,1,0,1],
                [0,1,0,1,0]
            ],
            'x': [
                [0,0,0,0,0],
                [1,0,0,0,1],
                [0,1,1,1,0],
                [0,1,1,1,0],
                [1,0,0,0,1]
            ],
            'y': [
                [1,0,0,0,1],
                [1,0,0,0,1],
                [0,1,1,1,1],
                [0,0,0,0,1],
                [0,1,1,1,0]
            ],
            'z': [
                [0,0,0,0,0],
                [1,1,1,1,1],
                [0,0,1,1,0],
                [0,1,1,0,0],
                [1,1,1,1,1]
            ]
        }
        
    def preprocess_image(self, image_path):
        image = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
        
        _, binary_image = cv2.threshold(image, 127, 255, cv2.THRESH_BINARY)
        
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
        
        avg_height = np.mean([r['height'] for r in regions])
        lines = []
        current_line = []
        
        sorted_regions = sorted(regions, key=lambda r: r['y'])
        
        for i, region in enumerate(sorted_regions):
            if not current_line:
                current_line.append(region)
            else:
                prev_region = current_line[-1]
                y_diff = abs(region['y'] - prev_region['y'])
                
                if y_diff <= avg_height * 0.5: 
                    current_line.append(region)
                else:
                    lines.append(current_line)
                    current_line = [region]
                    
        if current_line:
            lines.append(current_line)

        recognized_text = []
        
        for line in lines:            
            line.sort(key=lambda r: r['x'])
            
            line_text = []
            
            spacings = []
            for i in range(len(line) - 1):
                current_end = line[i]['x'] + line[i]['width']
                next_start = line[i + 1]['x']
                spacing = next_start - current_end
                spacings.append(spacing)
            
            if spacings:
                avg_spacing = np.mean(spacings)
                std_spacing = np.std(spacings)
                space_threshold = avg_spacing + std_spacing
            else:
                space_threshold = 20
            
            prev_end = None
            
            for region in line:              
                if prev_end is not None:
                    gap = region['x'] - prev_end
                    if gap > space_threshold:
                        line_text.append(' ')
                
                char_image = binary_image[
                    region['y']:region['y'] + region['height'] + 1,
                    region['x']:region['x'] + region['width'] + 1
                ]
                
                char_image = cv2.resize(char_image, (10, 10))
                char_image = cv2.resize(char_image, (5, 5))
                
                char_image = (char_image > 127).astype(np.int32)

                char = self.recognize_character(char_image)
                
                line_text.append(char)
                prev_end = region['x'] + region['width']
            
            recognized_text.append(''.join(line_text))
        
        result = '\n'.join(recognized_text)
        print(f"\nFinal recognized text:\n{result}")
        return result

    def calculate_match_score(self, window, pattern):
        pattern = np.array(pattern)
        window = window.astype(float)
        pattern = pattern.astype(float)
        
        weight_matrix = np.ones((5, 5))
        weight_matrix[:, [0, 4]] = 2.5 
        weight_matrix[:, [1, 3]] = 1.8 
        weight_matrix[3:, 1:4] = 2.0 
        
        diff = np.abs(window - pattern)
        weighted_diff = diff * weight_matrix
        
        try:
            ssim_score = 1 - ssim(window, pattern, data_range=1.0, win_size=3)
        except:
            ssim_score = np.sum(diff) / 25.0
        
        combined_score = (0.7 * np.sum(weighted_diff) / (25 * np.mean(weight_matrix))) + (0.3 * ssim_score)
        return combined_score

    def recognize_character(self, char_image):
        best_match = ' '
        best_score = float('inf')
        
        char_weights = {
            'W': 0.75,
            'V': 1.25,
            'N': 1.15,
            'M': 1.15,
            'U': 1.20,
            'T': 0.85,
            'E': 0.85,
            'S': 0.85,
            'O': 0.90,
            'R': 0.85,
            'C': 0.75,
            'A': 0.75,
            'G': 0.80,
            'B': 0.85,
            'D': 0.85,
            'F': 0.85,
            'H': 0.85,
            'I': 0.85,
            'J': 0.85,
            'K': 0.85,
            'L': 0.85
        }

        candidates = []
        for char, pattern in {k: v for k, v in self.patterns.items() 
                            if k.isupper()}.items():
            score = self.calculate_match_score(char_image, pattern)
            
            if char in char_weights:
                score *= char_weights[char]
            
            candidates.append((char, score))
            
            if score < best_score:
                best_score = score
                best_match = char

        if best_match in ['C', 'O']:
            c_score = next((score for char, score in candidates if char == 'C'), float('inf'))
            o_score = next((score for char, score in candidates if char == 'O'), float('inf'))
            
            left_side = char_image[:, 0]
            right_side = char_image[:, -1]
            
            if np.sum(right_side) < np.sum(left_side) * 0.5:
                best_match = 'C'
                best_score = c_score
            elif abs(np.sum(right_side) - np.sum(left_side)) < 2:
                best_match = 'O'
                best_score = o_score

        if best_match in ['4', 'A']:
            a_score = next((score for char, score in candidates if char == 'A'), float('inf'))
            four_score = next((score for char, score in candidates if char == '4'), float('inf'))
            if abs(a_score - four_score) < 0.2:
                best_match = 'A'
                best_score = a_score

        if best_match == 'C':
            threshold = 0.65
        elif best_match in ['A', 'G']:
            threshold = 0.6
        else:
            threshold = 0.5

        return best_match if best_score < threshold else ' '


def test_ocr():
    ocr = OcrAlgorithm()
    try:
        text = ocr.extract_text("9.png")
        print("Recognized text:")
        print(text)
    except Exception as e:
        print(f"Error during OCR: {str(e)}")

if __name__ == "__main__":
    test_ocr()