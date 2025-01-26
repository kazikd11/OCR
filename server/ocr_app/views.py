from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from django.core.files.storage import default_storage
import os
from algorithm import OcrAlgorithm

@csrf_exempt
def upload_image(request):
    if request.method != 'POST':
        return JsonResponse({'error': 'Invalid request method'}, status=405)

    if not request.FILES.get('file'):
        return JsonResponse({'error': 'No file provided'}, status=400)

    file = request.FILES['file']
    try:
        file_path = default_storage.save(file.name, file)

        ocr = OcrAlgorithm()
        try:
            text = ocr.extract_text(file_path)
            print(text)
        except Exception as e:
            print(f"Error during OCR: {str(e)}")
        
        response_message = text  
        
        os.remove(file_path)
        
        return JsonResponse({'message': response_message})
    except Exception as e:
        return JsonResponse({'error': str(e)}, status=400)
