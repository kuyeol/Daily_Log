# 1.  Find Pi number 
	s = 'Jen Smith, Thanh Doan3.14159265a2a2a2 - Jenn Smith, Jennifer blah, Test'
	re.findall(r'(\d\.\d*)\w', s)

# 2.  Find Jen, Jenny, Jennifer in list of names
	s = 'Jen Smith, Thanh Doan, Jennyt Book - Jenn Smith, Jennifer Doan, Test'
	re.findall(r'Je[nnifer|nny|n]{1,6}', s)
	
# 3.  Find Jen, Jenny, Jennifer in list of names
	s = 'Jen Smith, Thanh Doan, Jennyt Book - Jenn Smith, Jennifer Doan, Test'
	re.findall(r'Je[nnifer|nny|n]{1,6}', s)
	
# 4. matching  "525", "528", and "530" to "599" exclusively.
	s = '520521 525 526 528 528 529 530 531 100 521  532 533 534 536 535 537 538 539 540 541 549 550 551 552 553 559 521 560 562 561 599 598 500 528 528 525 525' 
	re.findall(r'525|528|53[1-9]|59[0-8]|5[4-8][0-9]',s)
		
# 5. matching phonenumber 
	s = '713-884-0576 ahaha 123- (832)591-2459/888.888.5523 -7138840576 ahahah, Thanh Doan, Jennyt Book - Jenn Smith, Jennifer Doan, Test'
	re.findall(r'\(?[0-9]{3}\)?[s.-]?[0-9]{3}[s.-]?[0-9]{4}', s)
	
	
